package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.repository.PatologiaRepository;

@Service
public class PatologiaServiceImpl implements PatologiaService{
	@Autowired
	PatologiaRepository patologiaRepository;

	@Override
	public void save(Patologia patologia) {
		patologiaRepository.save(patologia);
	}

	@Override
	public Patologia findById(int id) {
		return patologiaRepository.findById(id);
	}

	@Override
	public List<Patologia> findAll() {
		
		return patologiaRepository.findAll();
	}

	@Override
	public void deleteById(Patologia patologia) {
		patologiaRepository.delete(patologia);
	}

	@Override
	public List<Patologia> findByNombreIsLike(String nombre) {
		return patologiaRepository.findByNombreIgnoreCaseContaining(nombre);
	}
}
