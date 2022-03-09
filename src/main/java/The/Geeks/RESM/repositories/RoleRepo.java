package The.Geeks.RESM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import The.Geeks.RESM.domain.Role;

public interface RoleRepo extends JpaRepository <Role,Long> {
    Role  findByName(String name);

}
