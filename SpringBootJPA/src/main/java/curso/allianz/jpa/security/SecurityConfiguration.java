package curso.allianz.jpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import curso.allianz.jpa.services.JWTAuthorizationFilter;
import curso.allianz.jpa.services.UserDeatilServicesImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserDeatilServicesImpl service;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//http.authorizeRequests().antMatchers("/home").permitAll();
		http.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		//http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/user").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/api").access("ROLE_USER");
		http.authorizeRequests().antMatchers("/api").access("hasRole(\"ROLE_USER\")");
		//http.authorizeRequests().antMatchers("/resources/**").permitAll();
		
		/*http.formLogin().loginPage("/login");
		http.formLogin().loginProcessingUrl("/autenticar");
		http.formLogin().defaultSuccessUrl("/home");
		http.formLogin().failureUrl("/login?error=true");
		http.logout().logoutSuccessUrl("/login?logout=true");*/
		// http.formLogin().usernameParameter("usuario").passwordParameter("clave"); si
		// queremos usar otros nombres del formulario
		http.csrf().disable();
		http.cors();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getService()).passwordEncoder(encoder());

	}

	public BCryptPasswordEncoder encoder() {

		return new BCryptPasswordEncoder(4);
	}

	public UserDeatilServicesImpl getService() {
		return service;
	}

	public void setService(UserDeatilServicesImpl service) {
		this.service = service;
	}

}
