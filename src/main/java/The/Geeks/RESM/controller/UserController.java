package The.Geeks.RESM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import The.Geeks.RESM.dto.UserDto;
import The.Geeks.RESM.services.UserServices;
import The.Geeks.RESM.exception.UserException;
import The.Geeks.RESM.repositories.UserRepo;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = { "/api/v1/auth", "/api/v1" })
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserServices userServices;
    // @RequestMapping(value="/register", method=RequestMethod.POST)
    // public Object register (@RequestBody UserDto userDto)
    // {

    // try {
    // return UserServices.register(userDto);
    // } catch (UserException e) {
    // return e.getMessage();
    // }
    // }
    // @RequestMapping(value="/login", method=RequestMethod.POST)
    // public Object login(@RequestBody UserDto userDto) {

    // try {
    // return UserServices.login(userDto);
    // } catch (UserException e) {
    // return e.getMessage();
    // } }

    // @RequestMapping(value="/logout", method=RequestMethod.POST)
    // public Object logout(@RequestBody UserDto userDto) {
    // try {
    // return UserServices.logout(userDto);
    // } catch (UserException e) {
    // return e.getMessage();
    // }

    // }

}
