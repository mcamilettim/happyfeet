package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Tratamiento;
import cl.camiletti.happyFeetWeb.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService{
	@Autowired
	TratamientoRepository tratamientoRepository;

	@Override
	public void save(Tratamiento tratamiento) {
		tratamientoRepository.save(tratamiento);
	}

	@Override
	public Tratamiento findById(int id) {
		return tratamientoRepository.findById(id);
	}

	@Override
	public List<Tratamiento> findAll() {
		return tratamientoRepository.findAll();
	}

	@Override
	public void deleteById(Tratamiento tratamiento) {
		tratamientoRepository.delete(tratamiento);
	}
}
