package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.repository.ComunaRepository;

@Service
public class ComunaServiceImpl implements ComunaService{
	@Autowired
	ComunaRepository comunaRepository;

	@Override
	public void save(Comuna comuna) {
		comunaRepository.save(comuna);
	}

	@Override
	public Comuna findById(int id) {
		return comunaRepository.findById(id);
	}

	@Override
	public List<Comuna> findAll() {
		return comunaRepository.findAll();
	}

	@Override
	public void deleteById(Comuna comuna) {
		comunaRepository.delete(comuna);
	}
}
