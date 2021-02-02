package mx.com.springBootJWT.controller.api;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping(value="api")
public class LoginController {
	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	private String  login(Model model,Principal principal) {
		logger.info("Controller de login");
		if(principal!=null) {
			//El usuario ya inició sesion
			return ("redirect:/");
		}
		else {
			return "El usuario Sam inició sesion";
		}
	}
}
