package mx.com.springBootJWT.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import mx.com.springBootJWT.service.JWTService;
import mx.com.springBootJWT.service.JWTServiceImpl;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	JWTService jWTService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,JWTService jWTService) {
		super(authenticationManager);
		this.jWTService=jWTService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String tokenHeader = request.getHeader(JWTServiceImpl.NOMBRE_HEADER);
		UsernamePasswordAuthenticationToken autToken=null;

		if(jWTService.validarToken(tokenHeader)) {
			autToken=new UsernamePasswordAuthenticationToken(jWTService.getUsuario(tokenHeader),null,jWTService.getRoles(tokenHeader));
		}
		SecurityContextHolder.getContext().setAuthentication(autToken);
		chain.doFilter(request, response);
	}
	
}
