package pe.aplicacion.app.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.aplicacion.app.entities.Usuario;
import pe.aplicacion.app.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/usuarios")
	public List<Usuario> productos() {
		logger.info("call productos");
		
		List<Usuario> productos = usuarioService.findAll();
		logger.info("usuarios: " + productos);
		
		return productos;
	}
	@GetMapping("/usuarios/{id}")
	private Usuario obtener(@PathVariable("id")Long id) {
	Usuario usuario=usuarioService.findById(id);
	return usuario;
	
	}
	@PostMapping("/usuarios")
	public Usuario crear(@RequestParam("nombre") String nombre, @RequestParam("correo") String correo, @RequestParam("password")String password) throws Exception {
		logger.info("call crear(" + nombre + ", " + correo+ ", " + password + ")");
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setCorreo(correo);
		usuario.setPassword(password);
		
		usuarioService.save(usuario);
		
		return usuario;
	}
	
}
