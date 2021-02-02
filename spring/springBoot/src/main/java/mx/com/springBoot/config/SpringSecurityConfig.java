package mx.com.springBoot.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, 
securedEnabled = true, 
jsr250Enabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	
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
				.antMatchers("/","/index/**","/css/**","/js/**","/images/**").permitAll()
				//.antMatchers("/cliente/**").hasAnyRole("admin")
				.anyRequest().authenticated()
			.and()
				//.formLogin().loginPage("/login").permitAll()
				.formLogin().permitAll()
			.and()
				.logout().permitAll()
			.and()
				.httpBasic();
	}
	
	/*@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		UserBuilder userBuilder= User.builder().passwordEncoder(codificarPassword());
		builder
			.inMemoryAuthentication()
			.withUser(userBuilder.username("sam").password("123").roles("admin","user"))
			.withUser(userBuilder.username("naomi").password("123").roles("user"));
	}
	
	private Function<String,String> codificarPassword(){
		PasswordEncoder encoder=passwordEncoder();

		Function<String,String> funcion=(password)->{
			return encoder.encode(password);
		};
		return funcion;
	}*/
}
