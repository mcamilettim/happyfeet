package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	  <S extends Paciente> S save(Paciente paciente);
	  Paciente findByRut(String rut);
	  List<Paciente> findAll();	 	
	  void delete(Paciente paciente);	
	  Paciente findByEmail(String email);
	  List<Paciente> findByNombres(String nombre);	  
}

