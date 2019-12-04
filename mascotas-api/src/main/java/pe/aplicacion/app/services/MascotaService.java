package pe.aplicacion.app.services;

import java.util.List;

import pe.aplicacion.app.entities.Mascota;
public interface MascotaService {
	
	public List<Mascota> findAll();
	
	public Mascota findById(Long id);
	
	public void save(Mascota mascota);
	
	public void deleteById(Long id);


}
