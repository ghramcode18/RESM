package The.Geeks.RESM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import The.Geeks.RESM.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    User  findByUsername(String username);
}
