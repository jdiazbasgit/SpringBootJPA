package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidaddes.DatoPersonal;
import curso.allianz.jpa.enitidaddes.Hijo;

public interface DatoPersonalCrudRepository extends CrudRepository<DatoPersonal, Integer> {

}
