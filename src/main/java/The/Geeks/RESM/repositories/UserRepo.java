package The.Geeks.RESM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUserName(String userName);
=======
import The.Geeks.RESM.domain.User;
>>>>>>> jwt-with-another-way

public interface UserRepo  extends JpaRepository<User,Long>  {
    User  findByUsername(String username);
}
