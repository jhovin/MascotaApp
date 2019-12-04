package pe.aplicacion.app.services;

import java.util.List;

import pe.aplicacion.app.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public void save(Usuario usuario);
	
	public void deleteById(Long id);

}
