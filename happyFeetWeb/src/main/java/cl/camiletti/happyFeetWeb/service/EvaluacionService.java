package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Evaluacion;

public interface EvaluacionService {
	void save(Evaluacion evaluacion);
	Evaluacion findById(int id);
	List<Evaluacion> findAll();
	void deleteById(Evaluacion evaluacion);
}
