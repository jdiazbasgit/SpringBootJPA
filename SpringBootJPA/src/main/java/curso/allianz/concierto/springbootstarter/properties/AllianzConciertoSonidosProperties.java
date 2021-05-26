package curso.allianz.concierto.springbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties("allianz.concierto.sonido")
@Data
@Component
public class AllianzConciertoSonidosProperties {

    private String trompeta;

    private String tambor;
    
    private String guitarra;
    
}