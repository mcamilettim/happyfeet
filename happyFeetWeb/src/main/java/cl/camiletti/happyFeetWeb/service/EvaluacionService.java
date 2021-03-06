package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface EvaluacionService {
	void save(Evaluacion evaluacion);
	Evaluacion findById(int id);
	List<Evaluacion>  findByPodologo(Podologo podologo);
	List<Evaluacion>  findByPaciente(Paciente paciente);
	List<Evaluacion>  findByPacienteAndValorPodologoIn(Paciente paciente,List<Integer> valorPodologo);
	List<Evaluacion>  findByPacienteAndValorPodologoNotIn(Paciente paciente, List<Integer> valorPodologo);
	List<Evaluacion> findAll();
	void deleteById(Evaluacion evaluacion);
}
