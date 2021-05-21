package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidaddes.Empleado;
import curso.allianz.jpa.enitidaddes.Hijo;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

}
