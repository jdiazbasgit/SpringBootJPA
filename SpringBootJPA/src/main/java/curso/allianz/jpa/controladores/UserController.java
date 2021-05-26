package curso.allianz.jpa.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.allianz.jpa.dtos.UserDto;
import curso.allianz.jpa.enitidaddes.Authority;
import curso.allianz.jpa.repositorios.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@Autowired
	private UsuarioRepository   usuarioRepository;
	@PostMapping("user")
	public Optional<UserDto> login(@RequestParam("user") String  username, @RequestParam("password") String pwd) {
		
		UserDto user=null;
		
		BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
		
		if(username.equals(getUsuarioRepository().findUserByUser(username).getUsername()) && bcrypt.matches( pwd,getUsuarioRepository().findUserByUser(username).getPassword()))
		{
			
			String token = getJWTToken(username,getUsuarioRepository().findUserByUser(username).getAuthorities());
			 user = new UserDto();
			user.setUser(username);
			user.setToken(token);
			user.setRol(getUsuarioRepository().findUserByUser(username).getAuthorities());
			
		}
		
		
		//if(user==null)
			//return response.SC_UNAUTHORIZED;
		return Optional.ofNullable(user);
		
	}

	private String getJWTToken(String username, List<Authority> roles) {
		String secretKey = "allianz";
		
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		
		String token = Jwts
				.builder()
				.setId("cursoJWT")
				.setSubject(username)
				.claim("authorities",grantedAuthorities)
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
}
