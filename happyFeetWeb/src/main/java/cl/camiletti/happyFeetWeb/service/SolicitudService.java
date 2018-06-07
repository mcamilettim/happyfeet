package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Solicitud;

public interface SolicitudService {
	void save(Solicitud solicitud);

	Solicitud findById(int id);

	List<Solicitud> findAll();

	List<Solicitud> findByParamEstadoSolicitudIn(List<Parametro> parametro);

	List<Solicitud> findByParamEstadoSolicitudNotIn(List<Parametro> parametro);

	void deleteById(Solicitud solicitud);
}
