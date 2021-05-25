package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidades.DatoPersonal;
import curso.allianz.jpa.enitidades.Hijo;

public interface DatoPersonalCrudRepository extends CrudRepository<DatoPersonal, Integer> {

}
