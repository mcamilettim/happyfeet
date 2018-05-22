package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.repository.PodologoRepository;

@Service
public class PodologoServiceImpl implements PodologoService{
	@Autowired
	PodologoRepository podologoRepository;

	@Override
	public void save(Podologo podologo) {
		podologoRepository.save(podologo);
	}

	@Override
	public Podologo find(String rut) {
		return podologoRepository.findByRut(rut);
	}

	@Override
	public List<Podologo> findAll() {
		return podologoRepository.findAll();
	}

	@Override
	public void deleteById(Podologo podologo) {
		podologoRepository.delete(podologo);
	}

	@Override
	public Podologo findByEmail(String email) {
		return podologoRepository.findByEmail(email);
	}

	@Override
	public List<Podologo> findByUbicacion(Ubicacion ubicacion) { 
		// TODO Auto-generated method stub
		return podologoRepository.findByUbicacion(ubicacion);
	}
}
