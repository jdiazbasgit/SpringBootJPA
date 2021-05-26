package curso.allianz.concierto.springbootstarter.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import curso.allianz.concierto.instrumentos.Instrumento;
import curso.allianz.concierto.instrumentos.InstrumentoInterface;
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

	public void tocaHombreOrquesta() throws Exception {
		List<String> instrumentosString=getInstrumentos().getInstrumentosHombreombreorquesta();
		List<InstrumentoInterface> instrumentos= new ArrayList<InstrumentoInterface>();
		for (String instrumentoString : instrumentosString) {
			Instrumento instrumento= (Instrumento) Class.forName(INSTRUMENTOS_PROPIEDADES+instrumentoString).newInstance();
			Method getSonido =sonidos.getClass().getMethod("get"+instrumentoString);
			String sonido=(String) getSonido.invoke(sonidos);
			instrumento.setSonido(sonido);
			instrumentos.add(instrumento);
		}
		getHombreOrquesta().setInstrumentos(instrumentos);
		getHombreOrquesta().tocar();
	}

	public AllianzConciertoService(AllianzConciertoInstrumentosProperties instrumentos,
			AllianzConciertoSonidosProperties sonidos) {
		this.instrumentos = instrumentos;
		this.sonidos = sonidos;
	}

	

	

	

	
}
