package cl.camiletti.happyFeetWeb.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Notificacionpaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.repository.NotificacionpacienteRepository;

@Service
public class NotificacionpacienteServiceImpl implements NotificacionpacienteService {
	@Autowired
	NotificacionpacienteRepository notificacionpacienteRepository;

	@Override
	public void save(Notificacionpaciente notificacionpaciente) {
		notificacionpacienteRepository.save(notificacionpaciente);
	}

	@Override
	public List<Notificacionpaciente> findAll() {
		return notificacionpacienteRepository.findAll();
	}

	@Override
	public List<Notificacionpaciente> findByPaciente(Paciente paciente) {
		return notificacionpacienteRepository.findByPaciente(paciente);
	}

	@Override
	public List<Notificacionpaciente> findByPacienteAndParamEstadoNotificacion(Paciente paciente, Parametro parametro) {
		return notificacionpacienteRepository.findByPacienteAndParamEstadoNotificacionOrderByIdDesc(paciente, parametro);
	}

	@Override
	public Notificacionpaciente findByIdAndPaciente(int id, Paciente paciente) {
		return notificacionpacienteRepository.findByIdAndPaciente(id, paciente);
	}

	@Override
	public List<Notificacionpaciente> findByPacienteAndParamEstadoNotificacionNotIn(Paciente paciente,List<Parametro> parametros) {
		return notificacionpacienteRepository.findByPacienteAndParamEstadoNotificacionNotInOrderByIdDesc(paciente,parametros);
	}

	 

}
