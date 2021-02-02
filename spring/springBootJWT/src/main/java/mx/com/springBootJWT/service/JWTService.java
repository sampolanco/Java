package mx.com.springBootJWT.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.jsonwebtoken.Claims;

public interface JWTService {
	/*
	 * Metodo para crear un token a partir del objeto Authentication que se obtiene
	 * despues de validar el usuario, contraseña y marcó succesful
	 * */
	public String crearToken (Authentication auth) throws IOException;
	/*
	 * Metodo para validar si el token tiene formato valido (Bearer XXXX...)
	 * y si su firma es correcta
	 * */
	public boolean validarToken(String token);
	/*
	 * Metodo para obtener los Claims a partir del token
	 * */
	public Claims getClaims(String token);
	/*
	 * Metodo para obtener los Roles a partir del token
	 * */
	public Collection<? extends GrantedAuthority>  getRoles(String token) throws IOException;
	/*
	 * Metodo para obtener el usuario a partir del token
	 * */
	public String getUsuario(String token);
}
