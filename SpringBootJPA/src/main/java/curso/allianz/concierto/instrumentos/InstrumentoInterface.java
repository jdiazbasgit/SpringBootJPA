package curso.allianz.concierto.instrumentos;

import curso.allianz.concierto.excepciones.InstrumentoRotoException;

public interface InstrumentoInterface {
	
	public String sonar() throws InstrumentoRotoException;

}
