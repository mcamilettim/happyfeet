package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.HorarioRepository;

@Service
public class HorarioServiceImpl implements HorarioService{
	@Autowired
	HorarioRepository horarioRepository;

	@Override
	public void save(Horario horario) {
		horarioRepository.save(horario);
	}

	@Override
	public Horario findById(int id) {
		return horarioRepository.findById(id);
	}

	@Override
	public List<Horario> findAll() {
		return horarioRepository.findAll();
	}

	@Override
	public void deleteById(Horario horario) {
		horarioRepository.delete(horario);
	}

	@Override
	public List<Horario> findByPodologo(Podologo podologo) {
		return horarioRepository.findByPodologo(podologo);
	}
	
	@Override
	public List<Horario> findByFechaAndPodologo(String fecha, Podologo podologo) {
		return horarioRepository.findByFechaAndPodologo(fecha, podologo);
	}
}
