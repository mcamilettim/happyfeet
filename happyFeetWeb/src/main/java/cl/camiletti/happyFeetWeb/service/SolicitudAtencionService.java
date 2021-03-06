package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;

public interface SolicitudAtencionService {
	void save(Solicitudatencion solicitudAtencion);
	Solicitudatencion findById(int id);
	Solicitudatencion findByHorario(Horario horario);
	List<Solicitudatencion> findAll();
	List<Solicitudatencion> findByPaciente(Paciente paciente);
	void deleteById(Solicitudatencion solicitudAtencion);
	List<Solicitudatencion> findByPodologo(Podologo podologo);
	List<Solicitudatencion> findByParamEstadoSolicitudAtencion(Parametro parametro, Podologo podologo);
	List<Solicitudatencion> findByPodologoAndParamEstadoSolicitudAtencionNotIn(Podologo podologo, List<Parametro> parametros);
}
