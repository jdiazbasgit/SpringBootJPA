package curso.allianz.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan({"curso.allianz.concierto"})
public class SpringBootJpaApplication extends SpringBootServletInitializer{
	
	

	public static void main(String[] args) {
	
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

}
