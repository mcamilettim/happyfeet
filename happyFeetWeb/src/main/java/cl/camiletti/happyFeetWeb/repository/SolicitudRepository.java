package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Solicitud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
	  <S extends Solicitud> S save(Solicitud solicitud);
	  Solicitud findById(int id);
	  List<Solicitud> findAll();	 	
	  void delete(Solicitud solicitud);	 
}

