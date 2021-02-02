package mx.com.springBootJWT.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.springBootJWT.model.Usuario;

//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//@Secured(value="ROLE_ADMIN")  
@CrossOrigin(origins= {"http://localhost:4200"})
//@Secured(value="ROLE_VENDEDOR")  
@RestController
@RequestMapping("cliente")
public class ClienteController {
	private static final Logger logger=LoggerFactory.getLogger(ClienteController.class);

	//@Secured(value="ROLE_ADMIN") 
	@GetMapping("")
	public Usuario  getCliente(Authentication autentication) {
		Authentication otraManera = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> roles=otraManera.getAuthorities();
		
		
		logger.info("Controller de cliente" + otraManera.getName() + " Roles");
		roles.forEach(x-> logger.info(x.getAuthority()));

		Usuario u=new Usuario();
		u.setNombre(otraManera.getName());
		return  u;
	}
	
	@GetMapping(value="/{id}")
	public Usuario getById(@PathVariable Integer id) {
		logger.info("METODO GETBYID");
		Usuario saved=new Usuario(1,"usuarioActualizado","password1","correo1","123456");
		return saved;
	}
	@GetMapping("/getAll")
	public List<Usuario>  getAll() {
		List<Usuario> lista= new ArrayList<>();
		lista.add(new Usuario(1,"nombre1","password1","correo1","123456"));
		lista.add(new Usuario(1,"nombre2","password2","correo2","115645"));
		lista.add(new Usuario(1,"nombre3","password3","correo3","123665"));
		lista.add(new Usuario(1,"nombre4","password4","correo4","123215"));
		lista.add(new Usuario(1,"nombre5","password5","correo5","123456"));
		lista.add(new Usuario(1,"nombre6","password6","correo6","121456"));
		return  lista;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="")
	public Usuario post(@RequestBody Usuario dto) {
		logger.info("METODO POST");
		Usuario saved=new Usuario(1,"usuarioSalvado","password1","correo1","123456");
		return saved;
	}
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public Usuario put(@PathVariable Integer id,@RequestBody Usuario dto) {
		logger.info("METODO PUT");
		Usuario saved=new Usuario(1,"usuarioActualizado","password1","correo1","123456");
		return saved;
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public Boolean delete(@PathVariable Integer id) {
		logger.info("METODO DELETE");
		return true;
	}
}
