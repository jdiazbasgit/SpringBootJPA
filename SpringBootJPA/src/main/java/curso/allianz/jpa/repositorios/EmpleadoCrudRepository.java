package curso.allianz.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.allianz.jpa.enitidades.Empleado;
import curso.allianz.jpa.enitidades.Hijo;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

}
