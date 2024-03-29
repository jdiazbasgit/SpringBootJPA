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
import curso.allianz.jpa.enitidades.Authority;
import curso.allianz.jpa.repositorios.UsuarioCrudRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserRestController {

	@Autowired
	private UsuarioCrudRepository usuarioCrudRepository;

	@PostMapping("/user")
	public Optional<UserDto> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		UserDto user = null;

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		if (username.equals(getUsuarioCrudRepository().findByUserName(username).getUsername())
				&& bcrypt.matches(pwd, getUsuarioCrudRepository().findByUserName(username).getPassword())) {

			String token = getJWTToken(username, getUsuarioCrudRepository().findByUserName(username).getAuthority());
			user = new UserDto();
			user.setUser(username);
			user.setToken(token);
			user.setRol(getUsuarioCrudRepository().findByUserName(username).getAuthority());

		}

		// if(user==null) //return response.SC_UNAUTHORIZED; return
		return Optional.ofNullable(user);

	}

	private String getJWTToken(String username, Set<Authority> roles) {
		String secretKey = "cursocap";

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		for (Authority rol : roles) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getAuthority());
			grantedAuthorities.add(grantedAuthority);

		}

		String token = Jwts.builder().setId("cursoJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	public UsuarioCrudRepository getUsuarioCrudRepository() {
		return usuarioCrudRepository;
	}

	public void setUsuarioCrudRepository(UsuarioCrudRepository usuarioCrudRepository) {
		this.usuarioCrudRepository = usuarioCrudRepository;
	}

}
