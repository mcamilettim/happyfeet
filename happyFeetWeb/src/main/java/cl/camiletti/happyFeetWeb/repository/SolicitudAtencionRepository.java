package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;

public interface SolicitudAtencionRepository extends JpaRepository<Solicitudatencion, Long> {
	  <S extends Solicitudatencion> S save(Solicitudatencion solicitudAtencion);
	  Solicitudatencion findById(int id);
	  Solicitudatencion findByHorario(Horario horario);
	  List<Solicitudatencion> findAll();	 	
	  void delete(Solicitudatencion solicitudAtencion);	
	  List<Solicitudatencion> findByPodologo(Podologo podologo);
	  List<Solicitudatencion> findByParamEstadoSolicitudAtencionAndPodologo(Parametro parametro, Podologo podologo);
}

