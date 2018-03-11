package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Solicitud;

public interface SolicitudService {
	void save(Solicitud solicitud);
	Solicitud findById(int id);
	List<Solicitud> findAll();
	void deleteById(Solicitud solicitud);
}
