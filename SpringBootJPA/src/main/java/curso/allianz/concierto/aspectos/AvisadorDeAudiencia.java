package curso.allianz.concierto.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AvisadorDeAudiencia {

	@Pointcut("execution(@curso.allianz.concierto.anotaciones.Vigilante * *.*(..))")
	public void sujetador() {

	}

	@Before("sujetador()")
	public void apagarMoviles() {
		System.out.println("señores apaguen los moviles");

	}

	@AfterReturning("sujetador()")

	public void encenderMoviles() {

		System.out.println("Señores ya pueden encender los moviles");
	}
	
	@AfterThrowing("sujetador()")
	public void intrumetoRoto() {
		System.out.println("se ha roto el instrumento, pasen por taquilla a por el dinero");
	}
}
