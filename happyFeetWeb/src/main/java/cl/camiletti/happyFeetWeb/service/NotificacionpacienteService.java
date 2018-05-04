package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Notificacionpaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;

public interface NotificacionpacienteService {
	  void save(Notificacionpaciente notificacionpaciente);
	  List<Notificacionpaciente> findAll();	 
	  List<Notificacionpaciente> findByPaciente(Paciente paciente);	 
	  Notificacionpaciente findByIdAndPaciente(int id,Paciente paciente);	 
	  List<Notificacionpaciente> findByPacienteAndParamEstadoNotificacion(Paciente paciente,Parametro parametro);	
	  List<Notificacionpaciente> findByPacienteAndParamEstadoNotificacionNotIn(Paciente paciente,List<Parametro> parametros); 
}
