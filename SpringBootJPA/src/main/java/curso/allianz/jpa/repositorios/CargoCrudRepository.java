package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidades.Cargo;
import curso.allianz.jpa.enitidades.Hijo;

public interface CargoCrudRepository extends CrudRepository<Cargo, Integer> {

}
