package curso.allianz.jpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.allianz.jpa.enitidades.Usuario;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where u.username=:username")
	public Usuario findByUserName(String username);

 
}
