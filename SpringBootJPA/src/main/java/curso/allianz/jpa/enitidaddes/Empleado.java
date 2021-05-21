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

@Entity
@Table(name = "empleados")
@RestResource(path = "/empleados", rel = "empleado")
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public DatoLaboral getDatoLaboral() {
		return datoLaboral;
	}


	public void setDatoLaboral(DatoLaboral datoLaboral) {
		this.datoLaboral = datoLaboral;
	}


	public DatoPersonal getDatoPersonal() {
		return datoPersonal;
	}


	public void setDatoPersonal(DatoPersonal datoPersonal) {
		this.datoPersonal = datoPersonal;
	}

}
