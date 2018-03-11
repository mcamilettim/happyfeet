package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudAtencionRepository extends JpaRepository<Solicitudatencion, Long> {
	  <S extends Solicitudatencion> S save(Solicitudatencion solicitudAtencion);
	  Solicitudatencion findById(int id);
	  List<Solicitudatencion> findAll();	 	
	  void delete(Solicitudatencion solicitudAtencion);	
	  List<Solicitudatencion> findByPodologo(Podologo podologo);
	  List<Solicitudatencion> findByParamEstadoSolicitudAtencion(Parametro parametro);
}

