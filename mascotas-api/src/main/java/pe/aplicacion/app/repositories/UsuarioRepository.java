package pe.aplicacion.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.aplicacion.app.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Override
	List<Usuario> findAll();

}
