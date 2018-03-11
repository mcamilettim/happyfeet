package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Agenda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.camiletti.happyFeetWeb.model.Paciente;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	  <S extends Agenda> S save(Agenda agenda);
	  Agenda findById(int id);
	  List<Agenda> findAll();	 	
	  void delete(Agenda agenda);	 
	  List<Agenda> findByPaciente(Paciente paciente);
}

