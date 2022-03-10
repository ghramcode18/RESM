package The.Geeks.RESM.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import The.Geeks.RESM.domain.Role;
import The.Geeks.RESM.domain.User;
import The.Geeks.RESM.services.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RestController
@RequestMapping("/api/login")

public class UserResource {
     private final UserService userService;

     
    public UserResource(UserService userServices) {
        this.userService = userServices;
    }

    @GetMapping("/users")
    public ResponseEntity <List<User>>getUsers()
    {
   return ResponseEntity.ok().body(userService.getUsers());
    }
    @PostMapping("/user/save")
    public ResponseEntity <User>saveUser(@RequestBody User user)
    { URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
     return ResponseEntity.created(uri).body(userService.saveUser(user));
    }


    @PostMapping("/role/save")
    public ResponseEntity <Role>saveRole(@RequestBody Role role)
    { URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
     return ResponseEntity.created(uri).body(userService.saveRole(role));
    }


    @PostMapping("/role/addtouser")
    public ResponseEntity <?>addRoleToUser(@RequestBody RoleToUserForm form)
    {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
     return ResponseEntity.ok().build();
    }



    }
    @Data
    @Setter
    @Getter
class RoleToUserForm{

    private String username;
    private String roleName;
    public String getUsername() {
        return this.username;
    }
    public String getRoleName() {
        return this.roleName;
    }
   
    }
