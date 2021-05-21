package curso.allianz.jpa.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import curso.allianz.jpa.repositorios.HijoCrudRepository;

public class HijoRestController {
	
	@Autowired
	private HijoCrudRepository hijoCrudRepository;
	
	
	public void getAlgo() {
		
		
	}
	

	public HijoCrudRepository getHijoCrudRepository() {
		return hijoCrudRepository;
	}

	public void setHijoCrudRepository(HijoCrudRepository hijoCrudRepository) {
		this.hijoCrudRepository = hijoCrudRepository;
	}

}
