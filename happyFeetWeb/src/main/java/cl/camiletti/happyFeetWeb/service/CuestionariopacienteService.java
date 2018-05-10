package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;

public interface CuestionariopacienteService {
	void save(Cuestionariopaciente cuestionariopaciente);
	Cuestionariopaciente findById(int id);
	List<Cuestionariopaciente> findAll();
	void deleteById(Cuestionariopaciente cuestionariopaciente);
	List<Cuestionariopaciente>findByPaciente(Paciente paciente);
	List<Cuestionariopaciente>findByPacienteAndParamEstadoCuestionarioIn(Paciente paciente,List<Parametro> parametros);
 
}
