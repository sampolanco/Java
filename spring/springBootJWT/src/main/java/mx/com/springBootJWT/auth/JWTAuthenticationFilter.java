package mx.com.springBootJWT.auth;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.springBootJWT.model.Usuario;
import mx.com.springBootJWT.service.JWTService;
import mx.com.springBootJWT.service.JWTServiceImpl;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	JWTService jWTService;
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager,JWTService jWTService) {
		this.authenticationManager = authenticationManager;
		this.jWTService=jWTService;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
			
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if(username!=null && password!=null) {
			logger.info("Usuario obtenido desde el form-data");
			logger.info("Username:"+username + "-Password: "+ password);
		}
		else{
			Usuario usuario=null;
			try {
				usuario=new ObjectMapper().readValue(request.getInputStream(),Usuario.class);
				username=usuario.getNombre();
				password=usuario.getPassword();
				logger.info("Usuario obtenido desde el raw");
				logger.info("Username:"+username + "-Password: "+ password);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		username = username.trim();

		UsernamePasswordAuthenticationToken autToken=new UsernamePasswordAuthenticationToken(username,password);
		return authenticationManager.authenticate(autToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String token=jWTService.crearToken(authResult);
		response.addHeader(JWTServiceImpl.NOMBRE_HEADER, JWTServiceImpl.PREFIJO_BEARER+token);
		
		//Convertir a JSON y agregar al response
		Map<String,Object> body = new HashMap<>();
		body.put("token", token);
		body.put("user", authResult.getName());
		body.put("mensaje", "Has iniciado sesion");
		String bodyJson=new ObjectMapper().writeValueAsString(body);
		response.getWriter().write(bodyJson);
		response.setStatus(200);
		response.setContentType("application/json");
	}
}
