package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.repository.CuestionariopacienteRepository;

@Service
public class CuestionariopacienteServiceImpl implements CuestionariopacienteService{
	@Autowired
	CuestionariopacienteRepository cuestionariopacienteRepository;

	@Override
	public void save(Cuestionariopaciente cuestionariopaciente) {
		cuestionariopacienteRepository.save(cuestionariopaciente);
		
	}

	@Override
	public Cuestionariopaciente findById(int id) {
		// TODO Auto-generated method stub
		return cuestionariopacienteRepository.findById(id);
	}

	@Override
	public List<Cuestionariopaciente> findAll() {
		// TODO Auto-generated method stub
		return cuestionariopacienteRepository.findAll();
	}

	@Override
	public void deleteById(Cuestionariopaciente cuestionariopaciente) {
		cuestionariopacienteRepository.delete(cuestionariopaciente);
		
	}

	@Override
	public List<Cuestionariopaciente> findByPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return cuestionariopacienteRepository.findByPaciente(paciente);
	}

	 
}
