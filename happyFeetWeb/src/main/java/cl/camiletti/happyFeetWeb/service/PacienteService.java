package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface PacienteService {
	void save(Paciente paciente);
	Paciente find(String rut);
	List<Paciente> findAll();
	void deleteById(Paciente paciente);
	Paciente findByEmail(String email);
	List<Paciente> findByNombre(String nombre);
}
