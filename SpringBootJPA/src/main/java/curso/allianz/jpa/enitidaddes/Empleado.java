package curso.allianz.jpa.enitidaddes;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@RestResource(path = "/empleados", rel = "empleado")
@Data
@AllArgsConstructor

public class Empleado {
	



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int id;

	private String nombre;

	private String telefono;

	private String dni;

	private GregorianCalendar fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "datos_laborales_id")
	private DatoLaboral datoLaboral;

	
	@ManyToOne
	@JoinColumn(name = "datos_personales_id")
	private DatoPersonal datoPersonal;


	

}
