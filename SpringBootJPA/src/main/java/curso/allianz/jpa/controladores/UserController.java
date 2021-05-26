package curso.allianz.jpa.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.allianz.cursom.service.AllianzService;
import curso.allianz.jpa.dtos.UserDto;
import curso.allianz.jpa.repositorios.UsuarioRepository;
import lombok.Data;

@Controller
@Data
public class UserController {

	@Autowired
	private UsuarioRepository   usuarioRepository;
	
	@Autowired
	private AllianzService service;
	
	@PostMapping("user")
	public Optional<UserDto> login(@RequestParam("user") String  username, @RequestParam("password") String pwd) {
		
		
		
		
		return null;
		
	}
	
	@GetMapping("algo")
	public String algo() {
		getService().escribir("estoy en un  curso");
		
		return "home";
	}

	
	
}
