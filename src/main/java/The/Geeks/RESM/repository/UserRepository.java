package The.Geeks.RESM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import The.Geeks.RESM.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  User findByPassword(String password);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
