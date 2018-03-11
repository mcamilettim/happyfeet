package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Mensaje;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
	  <S extends Mensaje> S save(Mensaje mensaje);
	  Mensaje findById(int id);
	  List<Mensaje> findAll();	 	
	  void delete(Mensaje mensaje);	
	  List<Mensaje> findByEmisorRut(String emisor);
	  List<Mensaje> findByReceptorRut(String receptor);
}

