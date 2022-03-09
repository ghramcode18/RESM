package The.Geeks.RESM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import The.Geeks.RESM.domain.User;

public interface UserRepo  extends JpaRepository<User,Long>  {
    User  findByUsername(String username);
}
