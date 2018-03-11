package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.repository.UbicacionRepository;

@Service
public class UbicacionServiceImpl implements UbicacionService{
	@Autowired
	UbicacionRepository ubicacionRepository;

	@Override
	public void save(Ubicacion ubicacion) {		
		ubicacionRepository.save(ubicacion);
	}

	@Override
	public Ubicacion findById(int id) {
		return ubicacionRepository.findById(id);
	}

	@Override
	public List<Ubicacion> findAll() {
		return ubicacionRepository.findAll();
	}

	@Override
	public void deleteById(Ubicacion ubicacion) {
		ubicacionRepository.delete(ubicacion);
	}

	@Override
	public Ubicacion findByNombre(String name) {
		List<Ubicacion> lista=ubicacionRepository.findByNombre(name);
		for (Ubicacion ubicacion : lista) {
			return ubicacion;
		}
		return null;
	}
}
