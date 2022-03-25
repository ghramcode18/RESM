package The.Geeks.RESM.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import The.Geeks.RESM.dto.EstatesDto;
import The.Geeks.RESM.dto.UserDto;
import The.Geeks.RESM.entity.EstatesEntity;

@Service
public interface EstatesServices {
    public void setEstate(Integer userId, EstatesDto estatesDto);

    public void deleteEstate(Integer estateID);

    public EstatesDto updateEstate(EstatesDto estateDto);

    public UserDto sale(Integer uid, Integer estateID);

    public List<EstatesDto> getAllEstate();

    public EstatesDto searchByName(String propertyName);

    Page<EstatesEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


    EstatesEntity getEstatesEntityById(Integer id);

    public void save(EstatesEntity estateEntity);
    public void deleteEstatesEntityById(Integer id  );
}
