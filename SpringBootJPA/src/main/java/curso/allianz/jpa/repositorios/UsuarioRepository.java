package curso.allianz.jpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where u.user=:user")
	public Usuario findUserByUser(String user);
}
