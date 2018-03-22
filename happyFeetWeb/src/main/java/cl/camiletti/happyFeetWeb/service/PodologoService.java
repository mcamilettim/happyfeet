package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Podologo;

public interface PodologoService {
	void save(Podologo podologo);
	Podologo find(String rut);
	List<Podologo> findAll();
	void deleteById(Podologo podologo);
	Podologo findByEmail(String email);
	List<Podologo> findAllByComuna();
}
