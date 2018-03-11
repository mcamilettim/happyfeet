package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface MensajeService {
	void save(Mensaje mensaje);
	Mensaje findById(int id);
	List<Mensaje> findAll();
	void deleteById(Mensaje mensaje);
	List<Mensaje> findByRutEmisor(String rutEmisor);
    List<Mensaje> findByRutReceptor(String rutReceptor);
    List<Mensaje> cargarConversacion(Podologo podologo, Paciente paciente);
}
