package The.Geeks.RESM.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import The.Geeks.RESM.entity.EstatesEntity;

@Repository
public interface EstatesRepo extends JpaRepository<EstatesEntity, Integer> {

    EstatesEntity findByPropertyName(String propertyName);

}