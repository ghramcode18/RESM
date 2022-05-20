package The.Geeks.RESM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import The.Geeks.RESM.model.Role;

public interface RoleRepo extends JpaRepository <Role,Integer> {
    Role  findByName(String name);

}
