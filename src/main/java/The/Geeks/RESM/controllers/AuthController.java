package The.Geeks.RESM.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import The.Geeks.RESM.model.ERole;
import The.Geeks.RESM.model.Role;
import The.Geeks.RESM.model.User;
import The.Geeks.RESM.payload.request.LoginRequest;
import The.Geeks.RESM.payload.request.SignupRequest;
import The.Geeks.RESM.payload.response.MessageResponse;
import The.Geeks.RESM.payload.response.UserInfoResponse;
import The.Geeks.RESM.repository.RoleRepository;
import The.Geeks.RESM.repository.UserRepository;
import The.Geeks.RESM.security.jwt.JwtUtils;
import The.Geeks.RESM.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    String userName = loginRequest.getUsername();
    Optional<User> user  = userRepository.findByUsername(userName);
    user.get().setStatus(true);
    userRepository.save(user.get());

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(userDetails.getId(),
                                   userDetails.getUsername(),
                                   userDetails.getEmail(),
                                   roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
                         signUpRequest.getEmail(),
                         encoder.encode(signUpRequest.getPassword()),
                         signUpRequest.getStatus());

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
     String zipCode = genint(user);
     user.setZipCode(zipCode);
     userRepository.save(user);
     return ResponseEntity.ok().body(user);
     //.ok(new MessageResponse("User registered successfully!"));
     
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser(@Valid @RequestBody LoginRequest loginRequest) {
    String userName = loginRequest.getUsername();
    Optional<User> user = userRepository.findByUsername(userName);
    user.get().setStatus(false);
    userRepository.save(user.get());

    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }

  @RequestMapping("/testInteger")
  public String genint(User user) {

  int intRange;
  try {

  for (int i = 0; i < 10; i++) {
  intRange = generateRandomIntIntRange(1000, 10000);
  String num = Integer.toString(intRange);

   Random random = new Random();
   user.setZipCode(num);
   userRepository.save(user);
  }
  } catch (Exception e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
  }

  return user.getZipCode();

  }

  public static int generateRandomIntIntRange(int min, int max) {
  Random r = new Random();
  return r.nextInt((max - min) + 1) + min;

  }
}
