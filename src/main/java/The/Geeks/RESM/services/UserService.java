package The.Geeks.RESM.services;

import java.util.List;

import org.springframework.stereotype.Service;

import The.Geeks.RESM.domain.Role;
import The.Geeks.RESM.domain.User;

@Service
public interface UserService {
User saveUser (User user); 
 Role saveRole(Role role);
 void addRoleToUser(String username,String roleName);
 User getUser(String username);
 List <User> getUsers();
 
}
