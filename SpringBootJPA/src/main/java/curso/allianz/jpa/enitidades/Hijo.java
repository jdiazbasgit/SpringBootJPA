package curso.allianz.jpa.enitidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name="hijos")
@RestResource(path = "/hijos", rel = "hijo")
public class Hijo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int id;
	
	
	private int chicos;
	
	private int chicas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChicos() {
		return chicos;
	}

	public void setChicos(int chicos) {
		this.chicos = chicos;
	}

	public int getChicas() {
		return chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}

}
