package The.Geeks.RESM.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String username;

    private String password;

    @ManyToMany(mappedBy = "list_Estate")
    private Collection<EstatesEntity> estates = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Integer id, String username, String password, Collection<EstatesEntity> estates) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.estates = estates;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<EstatesEntity> getEstates() {
        return this.estates;
    }

    public void setEstates(Collection<EstatesEntity> estates) {
        this.estates = estates;
    }

    public UserEntity id(Integer id) {
        setId(id);
        return this;
    }

    public UserEntity username(String username) {
        setUsername(username);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity estates(Collection<EstatesEntity> estates) {
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
        return Objects.equals(id, userEntity.id) && Objects.equals(username, userEntity.username) && Objects.equals(password, userEntity.password) && Objects.equals(estates, userEntity.estates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, estates);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", estates='" + getEstates() + "'" +
            "}";
    }

}
