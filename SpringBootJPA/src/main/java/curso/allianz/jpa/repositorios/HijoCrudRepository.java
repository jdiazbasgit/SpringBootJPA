package curso.allianz.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import curso.allianz.jpa.enitidaddes.Hijo;

public interface HijoCrudRepository extends CrudRepository<Hijo, Integer> {

	
	@Query("from Hijo h where h.chicos>:chicos or h.chicas>:chicas")
	//@Query(value = "select id, chicos,chicas  from hijos where chicos>:chicos or chicas>:chicas" ,nativeQuery = true)
	public  List<Hijo> getChicosAndChicas( int chicos, int chicas);
	
}
