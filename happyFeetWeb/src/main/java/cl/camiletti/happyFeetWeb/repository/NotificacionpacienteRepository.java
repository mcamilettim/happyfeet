package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Notificacionpaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;

public interface NotificacionpacienteRepository extends JpaRepository<Notificacionpaciente, Long> {
	  <S extends Notificacionpaciente> S save(Notificacionpaciente notificacionpaciente);
	  List<Notificacionpaciente> findAll();	 
	  Notificacionpaciente findByIdAndPaciente(int id,Paciente paciente);	
	  List<Notificacionpaciente> findByPaciente(Paciente paciente);	 
	  List<Notificacionpaciente> findByPacienteAndParamEstadoNotificacion(Paciente paciente,Parametro parametro);	
}
