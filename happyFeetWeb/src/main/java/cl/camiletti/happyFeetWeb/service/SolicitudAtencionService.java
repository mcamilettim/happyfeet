package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;

public interface SolicitudAtencionService {
	void save(Solicitudatencion solicitudAtencion);
	Solicitudatencion findById(int id);
	List<Solicitudatencion> findAll();
	void deleteById(Solicitudatencion solicitudAtencion);
	List<Solicitudatencion> findByPodologo(Podologo podologo);
	List<Solicitudatencion> findByParamEstadoSolicitudAtencion(Parametro parametro, Podologo podologo);
}
