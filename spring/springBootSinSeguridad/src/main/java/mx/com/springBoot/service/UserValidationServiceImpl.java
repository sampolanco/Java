package mx.com.springBoot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import mx.com.springBoot.controller.ClienteController;
import mx.com.springBoot.model.Rol;
import mx.com.springBoot.model.Usuario;

@Service
public class UserValidationServiceImpl implements UserDetailsService{

	private static final Logger logger=LoggerFactory.getLogger(UserValidationServiceImpl.class);
	
	//Metodo que simula la llamada a la base de datos
	private Usuario getUsuarioByNombre(String nombre) {
		if(!nombre.equals("samuel"))
			return null;
		Usuario u=new Usuario();
		u.setId(1);
		u.setCorreo("correo");
		u.setNombre("samuel");
		u.setTelefono("4154");
		//Has para 123
		u.setPassword("$2a$10$OJTj/nBp1ofUibjUJM5CiuHht4n69MbXMfUiz2USlVmM2LAgwHP3i");
		return u;
	}
	private List getRolesByIdUsuario(Integer idUsuario) {
		Rol rol1=new Rol();
		Rol rol2=new Rol();
		rol1.setDescripcion("ROLE_VENDEDOR");
		rol2.setDescripcion("ROLE_CAJERO");
		
		List<Rol> lista=CollectionUtils.arrayToList(new Rol[]{rol1,rol2});
		return lista;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario=getUsuarioByNombre(username);
		if(usuario==null) {
			logger.info("No se encontró el usuario" + username);
			throw new UsernameNotFoundException("Error en el login del usuario");
		}
			
		List<Rol> roles=getRolesByIdUsuario(usuario.getId());
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		logger.info("Usuario: " + username+ " Roles: ");
		
		roles.forEach(x->{
				authorities.add(new SimpleGrantedAuthority(x.getDescripcion()));
				logger.info(x.getDescripcion()+",");
				return;
			}
		);
		
		UserDetails ud=new User(usuario.getNombre(), usuario.getPassword(), true, true, true, true, authorities);
		return ud;
	}
}
