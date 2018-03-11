package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Patologia;

public interface PatologiaService {
	void save(Patologia patologia);
	Patologia findById(int id);
	List<Patologia> findAll();
	void deleteById(Patologia patologia);
	List<Patologia> findByNombreIsLike(String nombre);
}
