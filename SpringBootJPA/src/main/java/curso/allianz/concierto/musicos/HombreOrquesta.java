package curso.allianz.concierto.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import curso.allianz.concierto.anotaciones.Vigilante;
import curso.allianz.concierto.excepciones.InstrumentoRotoException;
import curso.allianz.concierto.instrumentos.InstrumentoInterface;
import lombok.Data;

@Component
@Data
public class HombreOrquesta implements MusicoInterface {
	
	
	private List<InstrumentoInterface> instrumentos;

	@Override
	@Vigilante
	public void tocar() throws InstrumentoRotoException {
		for (InstrumentoInterface instrumento : instrumentos) {
			System.out.println(instrumento.sonar());
		}
	}
}
