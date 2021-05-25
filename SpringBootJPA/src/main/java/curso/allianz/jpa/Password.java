package curso.allianz.jpa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

	public static void main1(String[] args) {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(4);
		System.out.println(encoder.encode("1234"));
		
		System.out.println(encoder.matches("1234","$2a$04$CDBzJHLbDtwc9imNWI1wfOWVb9GMGt47mjjTvFQYIdCJD0dEa3dRm"));

	}

}
