package fit.iuh.services;

import java.util.List;

import fit.iuh.entities.User;


public interface UserService {
	public void save(User user);

	public User findByEmail(String email);

	public List<User> findAll();
}
