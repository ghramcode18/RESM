package The.Geeks.RESM.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity @Data 
@Setter 
@Getter
@RequiredArgsConstructor
@Table(name = "users", uniqueConstraints = {
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email")
})
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank
@Size(max = 20)
private String username;

@NotBlank
@Size(max = 50)
@Email
private String email;

@NotBlank
@Size(max = 120)
private String password;

@ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  

  public User(String username, String email, String password) {
     this.username = username;
     this.email = email;
     this.password = password;
  }

   public User(Long id, String username, String email, String password, Set<Role> roles) {
      this.id = id;
      this.username = username;
      this.email = email;
      this.password = password;
      this.roles = roles;
   }

}