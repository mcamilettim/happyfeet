package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Atencion;
import cl.camiletti.happyFeetWeb.model.Evaluacion;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {
	  <S extends Atencion> S save(Atencion atencion);
	  Atencion findById(int id);
	  Atencion findByAgenda(Agenda agenda);
	  Atencion findByEvaluacion(Evaluacion evaluacion);
	  List<Atencion> findAll();	 	
	  void delete(Atencion atencion);	
	  		  
}

