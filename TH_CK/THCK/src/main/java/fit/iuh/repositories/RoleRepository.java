package fit.iuh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.iuh.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	 public Role findByName(String name);
}
