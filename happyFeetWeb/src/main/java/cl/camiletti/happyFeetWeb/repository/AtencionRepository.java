package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Atencion;
import cl.camiletti.happyFeetWeb.model.Podologo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {
	  <S extends Atencion> S save(Atencion atencion);
	  Atencion findById(int id);
	  List<Atencion> findAll();	 	
	  void delete(Atencion atencion);	
	  List<Atencion> findByPodologo(Podologo podologo);		  
}

