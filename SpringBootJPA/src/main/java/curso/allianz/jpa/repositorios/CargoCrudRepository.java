package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidaddes.Cargo;
import curso.allianz.jpa.enitidaddes.Hijo;

public interface CargoCrudRepository extends CrudRepository<Cargo, Integer> {

}
