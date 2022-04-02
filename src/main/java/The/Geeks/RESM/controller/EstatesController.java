package The.Geeks.RESM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import The.Geeks.RESM.dto.EstatesDto;
import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.services.EstatesServicesImp;

@RestController
@RequestMapping(path = { "/", "/api/v1" })
public class EstatesController {
    @Autowired
    EstatesServicesImp estateServiceImp;

    @GetMapping("/getAllEstate")
    public List<EstatesDto> findAllEstates() {
        return estateServiceImp.getAllEstate();
    }

    @PostMapping("/setEstate/{Id}")
    public void saveNewEstates(@PathVariable(name = "Id")  Integer Id, @RequestBody EstatesDto estatesDto) {
        estateServiceImp.setEstate(Id, estatesDto);
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
