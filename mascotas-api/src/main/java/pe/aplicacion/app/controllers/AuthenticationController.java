package pe.aplicacion.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.aplicacion.app.entities.Usuario;
import pe.aplicacion.app.services.AuthenticationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
    private AuthenticationService authenticationService;
	
	
	@PostMapping("login")
	public Usuario login(@RequestParam String correo, @RequestParam String password)throws Exception {
		logger.info("login("+correo+", "+password+")");
		
		Usuario usuario = authenticationService.login(correo, password);
		logger.info("Login success: " + usuario);
		
		return usuario;
	}

}
