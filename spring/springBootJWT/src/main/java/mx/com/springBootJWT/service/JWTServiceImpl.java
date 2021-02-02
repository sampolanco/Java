package mx.com.springBootJWT.service;

import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import mx.com.springBootJWT.auth.SimpleGrantedAuthorityMixin;

@Component
public class JWTServiceImpl implements JWTService{
	public static final String NOMBRE_HEADER ="Authorization";
	public static final String PREFIJO_BEARER ="Bearer ";
	public static final long TIEMPO_EXPIRACION_TOKEN_MILIS =3600000;
	//la clave por default es generateKey
	public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	//SecretKey secretKey = Keys.hmacShaKeyFor("claveSecreta".getBytes());
	//public static final SecretKey secretKey = new SecretKeySpec("claveSecreta".getBytes(), SignatureAlgorithm.HS512.getJcaName());
	private static final Logger logger=LoggerFactory.getLogger(JWTServiceImpl.class);

	@Override
	public String crearToken(Authentication auth) throws IOException {
		Collection<? extends GrantedAuthority>  roles=auth.getAuthorities();
		Claims claims=Jwts.claims();
		claims.put("roles", new ObjectMapper().writeValueAsString(roles));
		String token =Jwts
				.builder()
				.setClaims(claims)
				.setSubject(auth.getName())
				.signWith(SECRET_KEY)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + TIEMPO_EXPIRACION_TOKEN_MILIS))
				.compact();
		return token;
	}

	@Override
	public boolean validarToken(String token) {
		try {
			getClaims(token);
			return true;
		}
		catch(JwtException ex) {
			logger.error("Error al validar el token");
			return false;
		}
	}

	@Override
	public Claims getClaims(String token) {
		Claims tokenClaims=null;
		tokenClaims= Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(limpiarToken(token))
				.getBody();
		return tokenClaims;
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException{
		Object roles=getClaims(token).get("roles");
		Collection<? extends GrantedAuthority>  rolesCollection= 
				Arrays.asList(
							new ObjectMapper()
							.addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
							.readValue(roles.toString().getBytes(),SimpleGrantedAuthority[].class)
							);
		return rolesCollection;
	}

	@Override
	public String getUsuario(String token) {
		return getClaims(token).getSubject();
	}

	private String limpiarToken(String token) {
		if(token!=null && token.startsWith(PREFIJO_BEARER))
			return token.replace(PREFIJO_BEARER, "");
		else
			return null;
	}
}
