package fit.iuh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.iuh.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}