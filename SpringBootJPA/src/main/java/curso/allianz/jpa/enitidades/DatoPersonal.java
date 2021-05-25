package curso.allianz.jpa.enitidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "datos_personales")
@RestResource(path = "/datosPersonales", rel = "datoPersonal")
public class DatoPersonal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int id;
	
	//@Column(name = "estado_civil") no es necesario
	private String estadoCivil;
	
	
	@ManyToOne
	@JoinColumn(name = "hijos_id")
	private Hijo hijo;


	public Hijo getHijo() {
		return hijo;
	}


	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
