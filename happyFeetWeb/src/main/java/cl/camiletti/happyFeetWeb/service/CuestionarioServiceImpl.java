package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.repository.CuestionarioRepository;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {
	@Autowired
	CuestionarioRepository cuestionarioRepository;

	@Override
	public Cuestionario save(Cuestionario cuestionario) {
		return cuestionarioRepository.save(cuestionario);
	}

	@Override
	public Cuestionario findById(int id) {
		return cuestionarioRepository.findById(id);
	}

	@Override
	public List<Cuestionario> findAll() {
		return cuestionarioRepository.findAll();
	}

	@Override
	public void delete(Cuestionario Cuestionario) {
		cuestionarioRepository.delete(Cuestionario);	
	}

	@Override
	public List<Cuestionario> findByTipo(String tipo) {
		return cuestionarioRepository.findByTipo(tipo);
	}

 

}
