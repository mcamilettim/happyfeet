package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.repository.EvaluacionRepository;
@Service
public class EvaluacionServiceImpl implements EvaluacionService{
	@Autowired
	EvaluacionRepository evaluacionRepository;

	@Override
	public void save(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evaluacion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluacion>  findByRutReceptor(String rutReceptor) {
		return evaluacionRepository.findByRutReceptor(rutReceptor);
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

 
}
