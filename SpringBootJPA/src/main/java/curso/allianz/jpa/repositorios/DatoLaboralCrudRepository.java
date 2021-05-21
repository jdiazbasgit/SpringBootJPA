package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidaddes.DatoLaboral;
import curso.allianz.jpa.enitidaddes.Hijo;

public interface DatoLaboralCrudRepository extends CrudRepository<DatoLaboral, Integer> {

}
