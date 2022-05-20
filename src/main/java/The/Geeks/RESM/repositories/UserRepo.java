package The.Geeks.RESM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import The.Geeks.RESM.model.User;

public interface UserRepo  extends JpaRepository<User,Integer>  {
    User  findByUsername(String username);
}
