package curso.allianz.concierto.instrumentos;

import curso.allianz.concierto.excepciones.InstrumentoRotoException;

public class Instrumento implements InstrumentoInterface {

	
	private String sonido;
	
	@Override
	public String sonar() throws InstrumentoRotoException {
		// TODO Auto-generated method stub
		
		if(getSonido().equals("nada"))
			throw new InstrumentoRotoException();
		return  getSonido();
	}
	public String getSonido() {
		return sonido;
	}
	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
