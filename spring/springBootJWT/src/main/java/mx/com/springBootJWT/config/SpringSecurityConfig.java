package mx.com.springBootJWT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mx.com.springBootJWT.auth.JWTAuthenticationFilter;
import mx.com.springBootJWT.auth.JWTAuthorizationFilter;
import mx.com.springBootJWT.service.JWTService;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, 
securedEnabled = true, 
jsr250Enabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	JWTService jWTService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/","/index/**","/css/**","/js/**","/images/**","/cliente/**").permitAll()
				.anyRequest().authenticated()
			 .and()
				.addFilter(new JWTAuthenticationFilter(this.authenticationManager(),this.jWTService))
				.addFilter(new JWTAuthorizationFilter(this.authenticationManager(),this.jWTService))
				.csrf()
					.disable()
					.sessionManagement()
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
