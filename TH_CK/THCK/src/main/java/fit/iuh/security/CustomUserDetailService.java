package fit.iuh.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.iuh.entities.User;
import fit.iuh.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
	
		if(user == null){
        	throw new UsernameNotFoundException("Invalid email or password");
        }
        
         return new org.springframework.security.core.userdetails.User(
        		user.getEmail(), 
        		user.getPassword(), 
        		user.getRoles()
        		.stream().map(
        				(role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
	}

}