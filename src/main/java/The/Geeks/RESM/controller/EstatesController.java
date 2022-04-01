package The.Geeks.RESM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping  ("/Estates")
    public List<EstatesDto> findAllEstates() {
        return estateServiceImp.getAllEstate();
    }

}
