package curso.allianz.jpa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import curso.allianz.jpa.repositorios.UsuarioCrudRepository;

@RestController
public class UserRestController {
	
	@Autowired
	private UsuarioCrudRepository usuarioCrudRepository;
	
	

	
	
	/*
	 * @PostMapping("/user") public Optional<UserDto> login(@RequestParam("user")
	 * String username, @RequestParam("password") String pwd) {
	 * 
	 * UserDto user=null;
	 * 
	 * BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
	 * 
	 * if(username.equals(getUsuarioCrudRepository().findByUserName(username).
	 * getUsername()) && bcrypt.matches(
	 * pwd,getUsuarioCrudRepository().findByUserName(username).getPassword())) {
	 * 
	 * String token =
	 * getJWTToken(username,getUsuarioCrudRepository().findByUserName(username).
	 * getAuthority()); user = new UserDto(); user.setUser(username);
	 * user.setToken(token);
	 * user.setRol(getUsuarioCrudRepository().findByUserName(username).getAuthority(
	 * ));
	 * 
	 * }
	 * 
	 * 
	 * //if(user==null) //return response.SC_UNAUTHORIZED; return
	 * Optional.ofNullable(user);
	 * 
	 * }
	 * 
	 * private String getJWTToken(String username, Set<Authority> roles) { String
	 * secretKey = "cursocap";
	 * 
	 * 
	 * List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	 * 
	 * for (Authority rol : roles) { GrantedAuthority grantedAuthority= new
	 * SimpleGrantedAuthority(rol.getAuthority());
	 * grantedAuthorities.add(grantedAuthority);
	 * 
	 * }
	 * 
	 * String token = Jwts .builder() .setId("cursoJWT") .setSubject(username)
	 * .claim("authorities", grantedAuthorities.stream()
	 * .map(GrantedAuthority::getAuthority) .collect(Collectors.toList()))
	 * .setIssuedAt(new Date(System.currentTimeMillis())) .setExpiration(new
	 * Date(System.currentTimeMillis() + 600000))
	 * .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
	 * 
	 * return "Bearer " + token; }
	 * 
	 * 
	 * 
	 * public UsuarioCrudRepository getUsuarioCrudRepository() { return
	 * usuarioCrudRepository; }
	 * 
	 * 
	 * 
	 * public void setUsuarioCrudRepository(UsuarioCrudRepository
	 * usuarioCrudRepository) { this.usuarioCrudRepository = usuarioCrudRepository;
	 * }
	 */
	
	
}
