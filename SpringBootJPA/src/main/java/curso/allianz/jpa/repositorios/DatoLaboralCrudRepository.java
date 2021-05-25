package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidades.DatoLaboral;
import curso.allianz.jpa.enitidades.Hijo;

public interface DatoLaboralCrudRepository extends CrudRepository<DatoLaboral, Integer> {

}
