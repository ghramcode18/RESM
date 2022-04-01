package The.Geeks.RESM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.services.EstatesServicesImp;
import org.springframework.ui.Model;
import The.Geeks.RESM.dto.EstatesDto;



@RestController
@RequestMapping(path = { "/", "/api/v1" })
public class EstatesController {
    @Autowired
    EstatesServicesImp estateServiceImp;

    @GetMapping  ("/getAllEstate")
    public List<EstatesDto> findAllEstates() {
        return estateServiceImp.getAllEstate();
    }


    
    @PostMapping("/setEstate")
    public void saveNewEstates(@RequestBody Integer Id, EstatesDto estatesDto) {
         estateServiceImp.setEstate(Id,estatesDto);
    }

    @GetMapping("/getEstatesEntityById/{id}")
    public EstatesEntity getEstatesEntityById(@PathVariable int id) {
        return estateServiceImp.getEstatesEntityById(id);
    }
    @GetMapping("/getEstatesEntityByName/{name}")
    public EstatesDto getEstatesEntityByName(@PathVariable String name) {
        return estateServiceImp.searchByName(name);
    }
    @PutMapping("/updateEstate")
    public EstatesDto updateEstate(@RequestBody EstatesDto estatesDto) {
        return estateServiceImp.updateEstate(estatesDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
         estateServiceImp.deleteEstatesEntityById(id);
    }



    
}
