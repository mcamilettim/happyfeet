package cl.camiletti.happyFeetWeb.service;

import java.util.ArrayList;
import java.util.List;

import cl.camiletti.happyFeetWeb.model.Parametro;

public interface ParametroService {
	void save(Parametro parametro);
	Parametro findOne(int id);
	List<Parametro> findAll();
	void deleteById(Parametro parametro);
	ArrayList<Parametro> findRolePodologoPaciente();
	List<Parametro> findByNumero(int numero);
}
