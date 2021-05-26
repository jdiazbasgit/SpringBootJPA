package curso.allianz.concierto.springbootstarter.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@ConfigurationProperties("allianz.concierto.instrumento")
@Data
public class AllianzConciertoInstrumentosProperties {

	private String instrumentoSolista;

	private List<String>   instrumentosHombreombreorquesta;

	
    
    
}