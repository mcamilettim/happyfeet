package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Tratamiento;

public interface TratamientoService {
	void save(Tratamiento tratamiento);
	Tratamiento findById(int id);
	List<Tratamiento> findAll();
	void deleteById(Tratamiento tratamiento);
}
