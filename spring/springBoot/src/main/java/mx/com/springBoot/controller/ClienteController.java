package mx.com.springBoot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Secured(value="ROLE_ADMIN")  
@RestController
@RequestMapping("cliente")
public class ClienteController {
	private static final Logger logger=LoggerFactory.getLogger(ClienteController.class);

	@Secured(value="ROLE_ADMIN") 
	@GetMapping("")
	private String  getCliente(Authentication autentication) {
		Authentication otraManera = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> roles=otraManera.getAuthorities();
		
		
		logger.info("Controller de cliente" + otraManera.getName() + " Roles");
		roles.forEach(x-> logger.info(x.getAuthority()));

		return  "Hola: "+autentication.getName();
	}
}
