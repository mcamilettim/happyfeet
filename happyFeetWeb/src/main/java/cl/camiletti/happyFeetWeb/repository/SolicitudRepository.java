package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Solicitud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
	<S extends Solicitud> S save(Solicitud solicitud);

	Solicitud findById(int id);

	List<Solicitud> findAll();

	List<Solicitud> findByParamEstadoSolicitudIn(List<Parametro> parametro);

	List<Solicitud> findByParamEstadoSolicitudNotIn(List<Parametro> parametro);

	void delete(Solicitud solicitud);
}
