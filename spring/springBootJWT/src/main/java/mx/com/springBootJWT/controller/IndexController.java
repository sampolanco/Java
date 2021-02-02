package mx.com.springBootJWT.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexController {
	private static final Logger logger=LoggerFactory.getLogger(IndexController.class);
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping({"","/index"})
	private String  get() {
		logger.info("Controller de index");
		//String password=bCryptPasswordEncoder.encode("123");
		//System.out.println("Generada por mi "+password);
		return "Accedí al get de index";
	}
	

	
	@RequestMapping("/logout")
	private String  logout(HttpServletRequest request,Authentication autentication) {
		logger.info("Controller de logout");
		return "El usuario "+autentication.getName()+" cerró sesion";
	}
}
