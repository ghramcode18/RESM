package The.Geeks.RESM.repositories;

import org.springframework.stereotype.Repository;

import The.Geeks.RESM.entity.UserEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo  extends JpaRepository<UserEntity,Integer>{
    
    Optional<UserEntity> findByUserName(String userName);

}
