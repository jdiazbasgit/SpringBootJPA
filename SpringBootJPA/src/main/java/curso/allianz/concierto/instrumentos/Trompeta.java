package curso.allianz.concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Trompeta extends Instrumento {
	
	@Value("${allianz.concierto.sonido.trompeta}")
	private String sonido;

	
	public String getSonido() {
		return sonido;
	}
	
	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
