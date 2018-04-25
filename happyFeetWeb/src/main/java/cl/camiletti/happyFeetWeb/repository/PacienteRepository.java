package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	  <S extends Paciente> S save(Paciente paciente);
	  Paciente findByRut(String rut);
	  List<Paciente> findAll();	 	
	  void delete(Paciente paciente);	
	  Paciente findByEmail(String email);
	  List<Paciente> findByNombres(String nombre);	  
}

