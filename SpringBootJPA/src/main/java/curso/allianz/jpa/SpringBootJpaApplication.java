package curso.allianz.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import curso.allianz.cursom.service.AllianzService;
import lombok.Data;

@SpringBootApplication
@ComponentScan("allianz.cursom")

public class SpringBootJpaApplication {

	@Autowired
	private AllianzService service;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	public AllianzService getService() {
		return service;
	}

	public void setService(AllianzService service) {
		this.service = service;
	}

}
