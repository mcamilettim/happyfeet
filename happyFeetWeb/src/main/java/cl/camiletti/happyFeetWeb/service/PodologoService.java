package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Ubicacion;

public interface PodologoService {
	void save(Podologo podologo);
	Podologo find(String rut);
	List<Podologo> findAll();
	void deleteById(Podologo podologo);
	Podologo findByEmail(String email);
	List<Podologo> findByUbicacion(Ubicacion ubicacion);
	
}
