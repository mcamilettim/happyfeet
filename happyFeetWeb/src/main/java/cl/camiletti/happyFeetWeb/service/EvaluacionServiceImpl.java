package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.EvaluacionRepository;
@Service
public class EvaluacionServiceImpl implements EvaluacionService{
	@Autowired
	EvaluacionRepository evaluacionRepository;

	@Override
	public void save(Evaluacion evaluacion) {
		evaluacionRepository.save(evaluacion);
	}

	@Override
	public Evaluacion findById(int id) {
		return evaluacionRepository.findById(id);
	}

	@Override
	public List<Evaluacion>  findByPodologo(Podologo podologo) {
		return evaluacionRepository.findByPodologo(podologo);
	}

	@Override
	public List<Evaluacion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evaluacion>findByPacienteAndValorPodologoNotIn(Paciente paciente, List<Integer> valorPodologo){
		// TODO Auto-generated method stub
		return evaluacionRepository.findByPacienteAndValorPodologoNotIn(paciente, valorPodologo);
	}

	@Override
	public List<Evaluacion> findByPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return evaluacionRepository.findByPaciente(paciente);
	}

	@Override
	public List<Evaluacion> findByPacienteAndValorPodologoIn(Paciente paciente, List<Integer> valorPodologo) {
		// TODO Auto-generated method stub
		return evaluacionRepository.findByPacienteAndValorPodologoIn(paciente, valorPodologo);
	}
 
 
}
