package fit.iuh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fit.iuh.entities.Role;
import fit.iuh.entities.User;
import fit.iuh.repositories.RoleRepository;
import fit.iuh.repositories.UserRepository;
import fit.iuh.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
	public void save(User user) {
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
        	role = new Role();
            role.setName("ROLE_ADMIN");
            roleRepository.save(role);
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        user.setRoles(List.of(role));
        userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
