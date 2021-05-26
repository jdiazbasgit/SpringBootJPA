package curso.allianz.jpa.dtos;

import java.util.List;
import java.util.Set;

import curso.allianz.jpa.enitidaddes.Authority;
import lombok.Data;
@Data
public class UserDto {

	private String user;
	
	private String token;
	
	private List <Authority> rol;

	
	

}