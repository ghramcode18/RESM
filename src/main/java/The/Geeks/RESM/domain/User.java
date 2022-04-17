package The.Geeks.RESM.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import The.Geeks.RESM.entity.EstatesEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity @Data 
@Setter 
@Getter
@NoArgsConstructor

@Table(name = "users")

public class User {

    public User(Integer id, String name, String username, String password, Collection<Role> roles, Collection<EstatesEntity> estates) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.estates = estates;
    }
    
    public User(Integer id, String name, String username, String password, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String name;
   private String username;
   private String password;
   @ManyToMany(fetch = FetchType.EAGER)
   private Collection <Role>roles= new ArrayList<>();

   
   @ManyToMany(mappedBy = "list_Estate")
   private Collection<EstatesEntity> estates = new ArrayList<>();



  
    
}
