package curso.allianz.concierto.springbootstarter.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;

import curso.allianz.concierto.excepciones.InstrumentoRotoException;
import curso.allianz.concierto.instrumentos.Instrumento;
import curso.allianz.concierto.instrumentos.Tambor;
import curso.allianz.concierto.musicos.HombreOrquesta;
import curso.allianz.concierto.musicos.Solista;
import curso.allianz.concierto.springbootstarter.properties.AllianzConciertoInstrumentosProperties;
import curso.allianz.concierto.springbootstarter.properties.AllianzConciertoSonidosProperties;
import lombok.Data;
@Data

public class AllianzConciertoService {

	
  final String INSTRUMENTOS_PROPIEDADES="curso.allianz.concierto.instrumentos.";
	
	private AllianzConciertoInstrumentosProperties instrumentos;
	
	private AllianzConciertoSonidosProperties sonidos;
	@Autowired
	private Solista solista;
	@Autowired
	private HombreOrquesta hombreOrquesta;
	@Autowired
	private Tambor tambor;
	
	

	
	public void tocaSolista() throws Exception{
		
		Instrumento instrumentoSolista=(Instrumento) Class.forName(INSTRUMENTOS_PROPIEDADES+getInstrumentos().getInstrumentoSolista()).newInstance();
		Method metodoSonido=instrumentoSolista.getClass().getMethod("setSonido", String.class);
		
	
		Method getSonido =sonidos.getClass().getMethod("get"+getInstrumentos().getInstrumentoSolista());
		String sonido=(String) getSonido.invoke(sonidos);
		
		metodoSonido.invoke(instrumentoSolista, sonido);
		getSolista().setInstrumento(instrumentoSolista);
		getSolista().tocar();
		
	}

	public void tocaHombreOrquesta() throws InstrumentoRotoException {
		//getHombreOrquesta().tocar();
	}

	public AllianzConciertoService(AllianzConciertoInstrumentosProperties instrumentos,
			AllianzConciertoSonidosProperties sonidos) {
		super();
		this.instrumentos = instrumentos;
		this.sonidos = sonidos;
	}

	

	

	

	
}
