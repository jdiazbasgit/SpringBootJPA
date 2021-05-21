package curso.allianz.jpa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.allianz.jpa.enitidaddes.Empleado;
import curso.allianz.jpa.repositorios.EmpleadoCrudRepository;

@RestController
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoCrudRepository empleadoCrudRepository;
	

	@GetMapping("/empleados")
	public Iterable<Empleado> getEmpleados(){
		
		return getEmpleadoCrudRepository().findAll();
	}
	
	
	
	
	
	
	public EmpleadoCrudRepository getEmpleadoCrudRepository() {
		return empleadoCrudRepository;
	}


	public void setEmpleadoCrudRepository(EmpleadoCrudRepository empleadoCrudRepository) {
		this.empleadoCrudRepository = empleadoCrudRepository;
	}


	




}
