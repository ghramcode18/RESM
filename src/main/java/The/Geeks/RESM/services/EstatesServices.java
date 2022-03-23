package The.Geeks.RESM.services;

import java.util.List;

import org.springframework.stereotype.Service;

import The.Geeks.RESM.dto.EstatesDto;
import The.Geeks.RESM.dto.UserDto;

@Service
public interface EstatesServices {
    public void setEstate(Integer userId, EstatesDto estatesDto);

    public void deleteEstate(Integer estateID);

    public EstatesDto updateEstate(EstatesDto estateDto);

    public UserDto sale(Integer uid, Integer estateID);

    public List<EstatesDto> getAllEstate();

    public EstatesDto searchByName(String propertyName);
}
