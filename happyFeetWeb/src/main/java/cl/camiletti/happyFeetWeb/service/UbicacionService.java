package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Ubicacion;

public interface UbicacionService {
	void save(Ubicacion ubicacion);
	Ubicacion findById(int id);
	List<Ubicacion> findAll();
	void deleteById(Ubicacion ubicacion);
	Ubicacion findByNombre(String name);
}
