package pe.aplicacion.app.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.aplicacion.app.entities.Mascota;
import pe.aplicacion.app.repositories.MascotaRepository;

@Service
@Transactional
public class MascotaServiceImpl implements MascotaService{

	@Autowired
	private MascotaRepository mascotaRepository;
	
	
	@Override
	public List<Mascota> findAll() {
		
		return mascotaRepository.findAll();
	}

	@Override
	public Mascota findById(Long id) {
		// TODO Auto-generated method stub
		return mascotaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void save(Mascota mascota) {
		mascotaRepository.save(mascota);
		
	}

	@Override
	public void deleteById(Long id) {
		mascotaRepository.deleteById(id);
		
	}

}
