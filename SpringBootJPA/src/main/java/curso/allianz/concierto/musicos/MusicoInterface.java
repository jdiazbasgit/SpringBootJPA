package curso.allianz.concierto.musicos;

import curso.allianz.concierto.excepciones.InstrumentoRotoException;

public interface MusicoInterface {
	
	public void tocar() throws InstrumentoRotoException;

}
