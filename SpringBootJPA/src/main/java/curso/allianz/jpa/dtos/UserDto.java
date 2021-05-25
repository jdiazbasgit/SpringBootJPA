package curso.allianz.jpa.dtos;

import java.util.Set;

import curso.allianz.jpa.enitidades.Authority;

public class UserDto {

	private String user;
	
	private String token;
	
	private Set<Authority> rol;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Authority> getRol() {
		return rol;
	}

	public void setRol(Set<Authority> rol) {
		this.rol = rol;
	}

	

}
