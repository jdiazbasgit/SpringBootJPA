package curso.allianz.concierto.springbootstarter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import curso.allianz.concierto.excepciones.InstrumentoRotoException;
import curso.allianz.concierto.springbootstarter.properties.AllianzConciertoInstrumentosProperties;
import curso.allianz.concierto.springbootstarter.properties.AllianzConciertoSonidosProperties;
import curso.allianz.concierto.springbootstarter.service.AllianzConciertoService;
import lombok.Data;

@Configuration
@ConditionalOnClass(AllianzConciertoService.class)
@EnableConfigurationProperties(AllianzConciertoInstrumentosProperties.class)
@Data
public class AllianzConciertoAutoConfigure {

	@Autowired
	private AllianzConciertoInstrumentosProperties instrumentosroperties;
	@Autowired
	private AllianzConciertoSonidosProperties sonidoProperties;
	
	@Bean
	@ConditionalOnMissingBean
	//@ConditionalOnProperty(prefix = "allianz.service", value = "enabled", havingValue = "true")

	AllianzConciertoService allianzConciertoService() throws InstrumentoRotoException {
		return new AllianzConciertoService(getInstrumentosroperties(),getSonidoProperties());
	}

}
