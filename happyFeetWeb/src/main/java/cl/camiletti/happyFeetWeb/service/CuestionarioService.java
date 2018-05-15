package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Cuestionario;

public interface CuestionarioService {
	Cuestionario save(Cuestionario cuestionario);

	Cuestionario findById(int id);

	List<Cuestionario> findAll();

	void delete(Cuestionario Cuestionario);

	List<Cuestionario> findByTipo(String tipo);
}
