// package The.Geeks.RESM.services;

// import java.util.List;
// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import The.Geeks.RESM.dto.EstatesDto;
// import The.Geeks.RESM.dto.UserDto;
// import The.Geeks.RESM.entity.EstatesEntity;
// import The.Geeks.RESM.entity.UserEntity;
// import The.Geeks.RESM.exception.EstatesException;
// import The.Geeks.RESM.exception.UserException;
// import The.Geeks.RESM.repositories.EstatesRepo;
// import The.Geeks.RESM.repositories.UserRepo;

// @Service
// public class EstatesServicesImp implements EstatesServices {
//     @Autowired
//     EstatesRepo estatesRepo;

//     @Autowired
//     UserRepo userRepo;

//     @Override
//     public void setEstate(Integer userId, EstatesDto estatesDto) {

//         EstatesEntity estateEntity;
//         estateEntity = estatesRepo.findById(estatesDto.getId())
//                 .orElseThrow(() -> new EstatesException("no estate with this id"));
//         UserEntity userEntity;
//         userEntity = userRepo.findById(userId).orElseThrow(() -> new UserException("no user with this id"));

//         List<UserEntity> userEntities = estateEntity.getUsers_added_to_estates();
//         int i = userEntities.stream().filter((user) -> user.getId().equals(userEntity.getId()))
//                 .toList().size();
//         if (i == 0)
//             userEntities.add(userEntity);
//         estateEntity.setUsers_added_to_estates(userEntities);
//         estatesRepo.save(estateEntity);

//     }

//     @Override
//     public void deleteEstate(Integer estateID) {

//         EstatesEntity estateEntity;
//         estateEntity = estatesRepo.findById(estateID)
//                 .orElseThrow(() -> new EstatesException("no estate with this id"));
//         estatesRepo.delete(estateEntity);

//     }

//     @Override
//     public UserDto sale(Integer uid, Integer estateID) {

//         UserEntity uentity = userRepo.findById(uid)
//                 .orElseThrow(() -> new UserException("no user with this id"));

//         EstatesEntity estateEntity = estatesRepo.findById(estateID)
//                 .orElseThrow(() -> new EstatesException("no estate with this id"));
//         List<EstatesEntity> estateiesEntity = new ArrayList<>();
//         estateiesEntity.add(estateEntity);

//         uentity.estates(estateiesEntity);
//         userRepo.save(uentity);
//         return UserEntityToUserDto(uentity);
//     }

//     private UserDto UserEntityToUserDto(UserEntity uentity) {
//         UserDto userDto = new UserDto();
//         userDto.password(uentity.getPassword())
//                 .userName(uentity.getUserName())
//                 .id(uentity.getId());
//         return userDto;
//     }

//     @Override
//     public EstatesDto updateEstate(EstatesDto estatesDto) {

//         EstatesEntity estateEntity;
//         estateEntity = estatesRepo.findById(estatesDto.getId())
//                 .orElseThrow(() -> new EstatesException("no estate with this id"));
//         estateEntity = estatesDtoToestatesEntity(estatesDto);

//         return estatesEntityToestatesDto(estatesRepo.save(estateEntity));
//     }

//     private EstatesDto estatesEntityToestatesDto(EstatesEntity estatesEntity) {
//         EstatesDto estateDto = new EstatesDto();
//         estateDto.buyerName(estatesEntity.getBuyerName())
//                 .propertyName(estatesEntity.getPropertyName())
//                 .sellingPrice(estatesEntity.getSellingPrice())
//                 .price(estatesEntity.getPrice())
//                 .sharesNumber(estatesEntity.getSharesNumber())
//                 .sale_date(estatesEntity.getSale_date());

//         return estateDto;
//     }

//     private EstatesEntity estatesDtoToestatesEntity(EstatesDto estateDto) {
//         EstatesEntity estatesEntity = new EstatesEntity();
//         estatesEntity.buyerName(estateDto.getBuyerName())
//                 .propertyName(estateDto.getPropertyName())
//                 .sellingPrice(estateDto.getSellingPrice())
//                 .price(estateDto.getPrice())
//                 .sharesNumber(estateDto.getSharesNumber())
//                 .sale_date(estateDto.getSale_date());

//         return estatesEntity;
//     }

//     @Override
//     public List<EstatesDto> getAllEstate() {
//         List<EstatesEntity> estatesEntity = estatesRepo.findAll();
//         return ListEstatesEntityToEstatesDto(estatesEntity);

//     }

//     private List<EstatesDto> ListEstatesEntityToEstatesDto(List<EstatesEntity> estatesEntities) {
//         List<EstatesDto> estatesDto = new ArrayList<>();
//         if (estatesEntities.size() > 0) {
//             for (EstatesEntity estateEntity : estatesEntities) {
//                 EstatesDto estateDto = new EstatesDto();
//                 estateDto.buyerName(estateEntity.getBuyerName())
//                         .propertyName(estateEntity.getPropertyName())
//                         .sellingPrice(estateEntity.getSellingPrice())
//                         .price(estateEntity.getPrice())
//                         .sharesNumber(estateEntity.getSharesNumber())
//                         .sale_date(estateEntity.getSale_date());

//                 estatesDto.add(estateDto);

//             }
//             return estatesDto;
//         } else {
//             return new ArrayList<EstatesDto>();
//         }

//     }

//     @Override
//     public EstatesDto searchByName(String propertyName) {
//         EstatesEntity entity = estatesRepo.findByPropertyName(propertyName);

//         return estatesEntityToestatesDto(entity);
//     }

// }
