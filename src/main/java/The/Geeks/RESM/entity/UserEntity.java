package The.Geeks.RESM.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name  = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class UserEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String password;


    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "users_added_to_estates")
    private List<EstatesEntity> estates;

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String password, List<EstatesEntity> estates) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.estates = estates;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<EstatesEntity> getEstates() {
        return this.estates;
    }

    public void setEstates(List<EstatesEntity> estates) {
        this.estates = estates;
    }

    public UserEntity id(Integer id) {
        setId(id);
        return this;
    }

    public UserEntity userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity estates(List<EstatesEntity> estates) {
        setEstates(estates);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(userName, userEntity.userName) && Objects.equals(password, userEntity.password) && Objects.equals(estates, userEntity.estates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, estates);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            ", estates='" + getEstates() + "'" +
            "}";
    }
    

}
