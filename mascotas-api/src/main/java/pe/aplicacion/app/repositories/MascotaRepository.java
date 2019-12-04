package pe.aplicacion.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.aplicacion.app.entities.Mascota;

public interface MascotaRepository extends CrudRepository<Mascota, Long> {
	@Override
	List<Mascota> findAll();

}
