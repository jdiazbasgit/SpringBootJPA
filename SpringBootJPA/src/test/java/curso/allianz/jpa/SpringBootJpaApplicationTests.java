package curso.allianz.jpa;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import curso.allianz.jpa.enitidaddes.Empleado;
import curso.allianz.jpa.enitidaddes.Hijo;
import curso.allianz.jpa.repositorios.EmpleadoCrudRepository;
import curso.allianz.jpa.repositorios.HijoCrudRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootJpaApplicationTests {

	@Autowired
	private HijoCrudRepository hijoCrudRepository;
	
	@Autowired
	private EmpleadoCrudRepository empleadoCrudRepository;
	
	@Test
	public void altaHijo() {
		
		Hijo hijo= new Hijo(0,5,6);
		
		System.err.println(getHijoCrudRepository());
		assertNotNull(getHijoCrudRepository().save(hijo));
		
		List<Hijo> hijos= getHijoCrudRepository().getChicosAndChicas(50, 3);
		for (Hijo hijo2 : hijos) {
			System.out.println("chicos:"+ hijo2.getChicos()+" - chicas:"+hijo2.getChicas());
		}
		
		Iterable<Empleado> empleados=getEmpleadoCrudRepository().findAll();
		
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getDatoLaboral().getCargo().getDescripcion());
		}
		
		
	}

	public EmpleadoCrudRepository getEmpleadoCrudRepository() {
		return empleadoCrudRepository;
	}

	public void setEmpleadoCrudRepository(EmpleadoCrudRepository empleadoCrudRepository) {
		this.empleadoCrudRepository = empleadoCrudRepository;
	}

	public HijoCrudRepository getHijoCrudRepository() {
		return hijoCrudRepository;
	}

	public void setHijoCrudRepository(HijoCrudRepository hijoCrudRepository) {
		this.hijoCrudRepository = hijoCrudRepository;
	}

}
