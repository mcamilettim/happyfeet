package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface HorarioService {
	void save(Horario horario);
	Horario findById(int id);
	List<Horario> findAll();
	void deleteById(Horario horario);
	List<Horario >findByPodologo(Podologo podologo);
}
