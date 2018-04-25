package cl.camiletti.happyFeetWeb.util;

import java.util.List;

import org.springframework.ui.Model;

import cl.camiletti.happyFeetWeb.model.Notificacionpaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.service.NotificacionpacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;

public class NotificacionUtil {
	public static void cargaNotificacionesPaciente(Model model, Paciente paciente,
			NotificacionpacienteService notificacionpacienteService, ParametroService parametroService) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Notificacionpaciente> notificaciones = notificacionpacienteService
				.findByPacienteAndParamEstadoNotificacion(paciente, parametro);
		model.addAttribute("notificaciones", notificaciones);
	}

	public static void cambiaEstadoNotificacionPaciente(Model model, Paciente paciente,
			NotificacionpacienteService notificacionpacienteService, ParametroService parametroService, int id) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		Notificacionpaciente notificacion = notificacionpacienteService.findByIdAndPaciente(id, paciente);
		if (notificacion != null) {
			notificacion.setParamEstadoNotificacion(parametro);
			notificacionpacienteService.save(notificacion);
		}
		cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
	}
}
