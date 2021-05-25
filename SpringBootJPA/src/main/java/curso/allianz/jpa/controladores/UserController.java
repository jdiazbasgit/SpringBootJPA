package curso.allianz.jpa.controladores;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.allianz.concierto.excepciones.InstrumentoRotoException;
import curso.allianz.concierto.springbootstarter.service.AllianzConciertoService;
import curso.allianz.jpa.dtos.UserDto;
import curso.allianz.jpa.enitidades.Authority;
import curso.allianz.jpa.enitidades.Usuario;
import curso.allianz.jpa.repositorios.UsuarioCrudRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

@RestController
@Data
public class UserController {

	
	@Autowired
	private UsuarioCrudRepository repository;
	
	@Autowired
	private AllianzConciertoService allianzConciertoService;

	@GetMapping({ "/", "/login" })
	public String index() {
		try {
			getAllianzConciertoService().tocaHombreOrquesta();
		} catch (InstrumentoRotoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("home")
	public String home() {

		return "home";
	}

	@PostMapping("/user")
	public UserDto getToken(@RequestParam String usuario, @RequestParam String clave) {

		UserDto salida = null;
		Usuario user = getRepository().findByUserName(usuario);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		if (user.getUsername().equals(usuario) && encoder.matches(clave, user.getPassword())) {

			String token = getJWTToken(user.getUsername(), user.getAuthority());
			salida = new UserDto();
			salida.setUser(usuario);
			salida.setToken(token);
			salida.setRol(user.getAuthority());
		}

		return salida;

	}

	private String getJWTToken(String username, Set<Authority> roles) {
		String secretKey = "allianz";
		

		String token = Jwts.builder().setId("allianz").setSubject(username).claim("authorities", roles)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	
}
