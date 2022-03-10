package The.Geeks.RESM.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Data
@Setter 
@Getter
public class Role {

    

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    public Role(){}
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
