package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface MensajeService {
	void save(Mensaje mensaje);

	Mensaje findById(int id);
	Mensaje findByIdAndPaciente(int id, Paciente paciente);
	List<Mensaje> findAll();

	void deleteById(Mensaje mensaje);

	List<Mensaje> findByEmisorRut(String rutEmisor);

	List<Mensaje> findByEmisorRutAndParamEstadoMensaje(String rutEmisor, Parametro paramEstadoMensaje);

	List<Mensaje> findByReceptorRutAndParamEstadoMensaje(String rutReceptor, Parametro paramEstadoMensaje);

	List<Mensaje> findByReceptorRut(String rutReceptor);

	List<Mensaje> cargarConversacionPodologo(Podologo podologo, Paciente paciente);

	List<Mensaje> cargarConversacionPaciente(Paciente paciente, Podologo podologo);

	void updateEstadoMensajeVisto(List<Mensaje> mensajes,Parametro parametro);
}
