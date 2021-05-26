package curso.allianz.concierto.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class MecanicoDeInstrumentos {
	
	@Pointcut("execution(@curso.allianz.concierto.anotaciones.Vigilante * *.*(..))")
	public void sujetador() {

	}
	
	
	@Around("sujetador()")
	public Object arreglarInstrumento(ProceedingJoinPoint joinpoint) {
		
	
		
		return null;
	}


}
