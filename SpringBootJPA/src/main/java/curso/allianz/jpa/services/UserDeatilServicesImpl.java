package curso.allianz.jpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import curso.allianz.jpa.enitidades.Authority;
import curso.allianz.jpa.enitidades.Usuario;
import curso.allianz.jpa.repositorios.UsuarioCrudRepository;


@Service
public class UserDeatilServicesImpl implements UserDetailsService {

	@Autowired
	private UsuarioCrudRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario=getRepository().findByUserName(username);
		
		List<GrantedAuthority> autorities= new ArrayList<>();
		
		for (Authority rol : usuario.getAuthority()) {
			
			GrantedAuthority auth= new SimpleGrantedAuthority(rol.getAuthority());
			autorities.add(auth);
			
		}
		
		User user= new User(usuario.getUsername(),usuario.getPassword(),usuario.isEnabled(),true, true, true,autorities);
		
		
		
		return user;
	}

	public UsuarioCrudRepository getRepository() {
		return repository;
	}

	public void setRepository(UsuarioCrudRepository repository) {
		this.repository = repository;
	}

}
