package The.Geeks.RESM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import The.Geeks.RESM.dto.EstatesDto;
import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.services.EstatesServicesImp;
import org.springframework.ui.Model;

// @RestController
// @RequestMapping(path = { "/" })
@Controller
public class EstatesController {
    @Autowired
    EstatesServicesImp estateServiceImp;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Object viewHomePage(EstatesDto estatesDto, Model model) {
        List<EstatesDto> list = estateServiceImp.getAllEstate();
        model.addAttribute("list", list);
         return "index";

    }

    // @GetMapping("/")    
    // public String home( Model model) {
    //     List<EstatesEntity> list = estateServiceImp.getAllShops();
    //     model.addAttribute("list", list);
    //     return "index";
    // }

    @GetMapping("/add")
    public String showAddForm(EstatesDto EstatesDto, Model model) {
        return "add-shop";
    }

    @PostMapping("/save")
    public String create(EstatesDto estatesDto, Model model) {
        estateServiceImp.updateEstate(estatesDto);
        return "redirect:/";
    }

    // @RequestMapping(path = { "/update", "/update/{id}" })
    // public String update(Model model, @PathVariable("id") Integer id) {
    // if (id != null) {
    // EstatesDto estatesDto2 = estateServiceImp.getShopById(id);
    // model.addAttribute("shop", estatesDto2);
    // } else {
    // model.addAttribute("shop", new EstatesDto());
    // }
    // return "add-shop";
    // }

    @RequestMapping(path = { "/delete/{id}" })
    public String delete(Model model, @PathVariable("id") Integer id) {
        estateServiceImp.deleteEstate(id);
        return "redirect:/";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
   	// display list of EstatesEntity
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return  findPaginated(1, "propertyName", "asc", model);	
	}

    @GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<EstatesEntity> page = estateServiceImp.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<EstatesEntity> listEstatesEntity = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listEstatesEntity", listEstatesEntity);
		return "index";
	}

    @GetMapping("/showNewEstatesEntityForm")
	public String showNewEstatesEntityForm(Model model) {
		// create model attribute to bind form data
		EstatesEntity estatesEntity = new EstatesEntity();
		model.addAttribute("estatesEntity", estatesEntity);
		return "new_estatesEntity";
	}
    @PostMapping("/saveEstatesEntity")
	public String saveEstates(@ModelAttribute("estatesEntity") EstatesEntity estatesEntity) {
		// save estatesEntity to database
		estateServiceImp.save(estatesEntity);
		return "redirect:/";
	}

    	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") Integer id, Model model) {
		
		// get estatesEntity from the service
		EstatesEntity estatesEntity= estateServiceImp.getEstatesEntityById(id);
		
		// set estatesEntity as a model attribute to pre-populate the form
		model.addAttribute("estatesEntity", estatesEntity);
		return "update_estatesEntity";
	}
	

    @GetMapping("/deleteEstatesEntity/{id}")
	public String deleteEstatesEntity(@PathVariable (value = "id") Integer id) {
		
		// call delete estatesEntity method 
		this.estateServiceImp.deleteEstatesEntityById(id);
		return "redirect:/";

	}
	
}
