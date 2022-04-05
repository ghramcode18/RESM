package The.Geeks.RESM.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import The.Geeks.RESM.dto.EstatesDto;
import The.Geeks.RESM.dto.UserDto;
import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.entity.UserEntity;
import The.Geeks.RESM.exception.EstatesException;
import The.Geeks.RESM.exception.UserException;
import The.Geeks.RESM.repositories.EstatesRepo;
import The.Geeks.RESM.repositories.UserRepo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Aspect

public class EstatesServicesImp implements EstatesServices {
     
    private static final Logger LOGGER = LogManager.getLogger(EstatesServicesImp.class);


    @Autowired
    EstatesRepo estatesRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public Object setEstateToUser(Integer userId, Integer estateId) {
    //TODO ID RETURN NULL please fix me 
        EstatesEntity estateEntity;
        estateEntity = estatesRepo.findById(estateId)
                .orElseThrow(() -> new EstatesException("no estate with this id"));
        UserEntity userEntity;
        userEntity = userRepo.findById(userId).orElseThrow(() -> new UserException("no user with this id"));

        List<UserEntity> userEntities = estateEntity.getList_Estate();
        int i = userEntities.stream().filter((user) -> user.getId().equals(userEntity.getId()))
                .toList().size();
        if (i == 0)
            userEntities.add(userEntity);
        estateEntity.setList_Estate(userEntities);
        estatesRepo.save(estateEntity);
        return estatesEntityToestatesDto(estateEntity);

    }

    @Override
    public void save(EstatesEntity estateEntity) {
        this.estatesRepo.save(estateEntity);
    }

    @Override
    public EstatesEntity getEstatesEntityById(Integer id) {
        Optional<EstatesEntity> optional = estatesRepo.findById(id);
        EstatesEntity estateEntity = null;
        if (optional.isPresent()) {
            estateEntity = optional.get();
        } else {
            throw new RuntimeException(" EstatesEntity not found for id :: " + id);
        }
        return estateEntity;
    }

    @Override
    public void deleteEstatesEntityById(Integer id) {
        this.estatesRepo.deleteById(id);
    }

    @Override
    public void deleteEstate(Integer estateID) {

        EstatesEntity estateEntity;
        estateEntity = estatesRepo.findById(estateID)
                .orElseThrow(() -> new EstatesException("no estate with this id"));
        estatesRepo.delete(estateEntity);

    }

    @Override
    public UserDto sale(Integer uid, Integer estateID) {

        UserEntity uentity = userRepo.findById(uid)
                .orElseThrow(() -> new UserException("no user with this id"));

        EstatesEntity estateEntity = estatesRepo.findById(estateID)
                .orElseThrow(() -> new EstatesException("no estate with this id"));
        List<EstatesEntity> estateiesEntity = new ArrayList<>();
        estateiesEntity.add(estateEntity);

        uentity.estates(estateiesEntity);
        userRepo.save(uentity);
        return UserEntityToUserDto(uentity);
    }

    private UserDto UserEntityToUserDto(UserEntity uentity) {
        UserDto userDto = new UserDto();
        userDto.password(uentity.getPassword())
                .userName(uentity.getUserName())
                .id(uentity.getId());
        return userDto;
    }

    @Override
    public EstatesDto updateEstate(EstatesDto estatesDto) {

        EstatesEntity estateEntity;
        estateEntity = estatesRepo.findById(estatesDto.getId())
                .orElseThrow(() -> new EstatesException("no estate with this id"));
        estateEntity = estatesDtoToestatesEntity(estatesDto);

        return estatesEntityToestatesDto(estatesRepo.save(estateEntity));
    }

    private EstatesDto estatesEntityToestatesDto(EstatesEntity estatesEntity) {
        EstatesDto estateDto = new EstatesDto();
        estateDto.buyerName(estatesEntity.getBuyerName())
                .propertyName(estatesEntity.getPropertyName())
                .sellingPrice(estatesEntity.getSellingPrice())
                .price(estatesEntity.getPrice())
                .sharesNumber(estatesEntity.getSharesNumber())
                .sale_date(estatesEntity.getSale_date())
                .id(estateDto.getId());
                ;

        return estateDto;
    }

    private EstatesEntity estatesDtoToestatesEntity(EstatesDto estateDto) {
        EstatesEntity estatesEntity = new EstatesEntity();
        estatesEntity.buyerName(estateDto.getBuyerName())
                .propertyName(estateDto.getPropertyName())
                .sellingPrice(estateDto.getSellingPrice())
                .price(estateDto.getPrice())
                .sharesNumber(estateDto.getSharesNumber())
                .sale_date(estateDto.getSale_date())
                .id(estateDto.getId());
                ;

        return estatesEntity;
    }

    @Override
    public List<EstatesDto> getAllEstate() {
        List<EstatesDto> estatesDto = new ArrayList<>();
        try {
            List<EstatesEntity> estatesEntity = estatesRepo.findAll();
            estatesDto  =  ListEstatesEntityToEstatesDto(estatesEntity);
            LOGGER.info(" no error occured, everything same be in order", estatesDto.size());
            LOGGER.info(" no error occured, everything same be in order", estatesDto.get(1));

        } catch (Exception exception) {
            LOGGER.error("Error occurred in business service : {}",exception.getMessage());

        }
        return estatesDto;
    }

    public List<EstatesEntity> getAllShops() {
        List<EstatesEntity> list = estatesRepo.findAll();
        return list;
    }

    @Override
    public Page<EstatesEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.estatesRepo.findAll(pageable);
    }

    private List<EstatesDto> ListEstatesEntityToEstatesDto(List<EstatesEntity> estatesEntities) {
        List<EstatesDto> estatesDto = new ArrayList<>();
        if (estatesEntities.size() > 0) {
            for (EstatesEntity estateEntity : estatesEntities) {
                EstatesDto estateDto = new EstatesDto();
                estateDto.buyerName(estateEntity.getBuyerName())
                        .propertyName(estateEntity.getPropertyName())
                        .sellingPrice(estateEntity.getSellingPrice())
                        .price(estateEntity.getPrice())
                        .sharesNumber(estateEntity.getSharesNumber())
                        .sale_date(estateEntity.getSale_date())
                        .id(estateEntity.getId());

                estatesDto.add(estateDto);

            }
            return estatesDto;
        } else {
            return new ArrayList<EstatesDto>();
        }

    }

    @Override
    public EstatesDto searchByName(String propertyName) {
        EstatesEntity entity = estatesRepo.findByPropertyName(propertyName);

        return estatesEntityToestatesDto(entity);
    }
    

}
