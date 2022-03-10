package The.Geeks.RESM.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity @Data 
@Setter 
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   private String username;
   private String password;
   @ManyToMany(fetch = FetchType.EAGER)
   private Collection <Role>roles= new ArrayList<>();

   public User(){}
public User(Long id, String name, String username, String password, Collection<Role> roles) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.roles = roles;
}
public String getName() {
    return name;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public void setName(String name) {
    this.name = name;
}
public Collection<Role> getRoles() {
    return  roles;
}

  
    
}
