package curso.allianz.concierto.musicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import curso.allianz.concierto.anotaciones.Vigilante;
import curso.allianz.concierto.excepciones.InstrumentoRotoException;
import curso.allianz.concierto.instrumentos.InstrumentoInterface;
import lombok.Data;

@Component
@Data
public class Solista implements MusicoInterface{
	
	
	
	private InstrumentoInterface instrumento;

	@Override
	@Vigilante
	public void tocar() throws InstrumentoRotoException {
		System.out.println(instrumento.sonar());
		
	}

	

	

}
