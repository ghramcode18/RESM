package The.Geeks.RESM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import The.Geeks.RESM.repositories.UserRepo;
import The.Geeks.RESM.services.UserServicesImp;

@RestController
@RequestMapping(path = { "/api/v1/auth", "/api/v1" })
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserServicesImp userServices;

}
