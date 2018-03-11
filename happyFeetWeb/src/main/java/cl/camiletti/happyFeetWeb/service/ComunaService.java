package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Comuna;

public interface ComunaService {
	void save(Comuna comuna);
	Comuna findById(int id);
	List<Comuna> findAll();
	void deleteById(Comuna comuna);
}
