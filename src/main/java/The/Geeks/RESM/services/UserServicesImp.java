package The.Geeks.RESM.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import The.Geeks.RESM.domain.Role;
import The.Geeks.RESM.domain.User;
import The.Geeks.RESM.repositories.RoleRepo;
import The.Geeks.RESM.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServicesImp implements UserService, UserDetailsService {

    @Autowired
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to ", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching All users {}");

        return userRepo.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role{} to the database ", role.getName());

        return roleRepo.save(role);
    }

    @Override
    public User saveUser(User user) {
        log.info("saving new user{} to the database ", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("user not found in the database");
            throw new UsernameNotFoundException("user not found in the database");

        } else {
            log.info("user found in the database :{}", username);

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        log.info(user.getName() +"&&   "+ user.getPassword());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

}
