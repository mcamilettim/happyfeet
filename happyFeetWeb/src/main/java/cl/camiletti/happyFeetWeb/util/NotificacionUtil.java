package cl.camiletti.happyFeetWeb.util;

import java.util.List;

import org.springframework.ui.Model;

import cl.camiletti.happyFeetWeb.model.Notificacionpaciente;
import cl.camiletti.happyFeetWeb.model.Notificacionpodologo;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.service.NotificacionpacienteService;
import cl.camiletti.happyFeetWeb.service.NotificacionpodologoService;
import cl.camiletti.happyFeetWeb.service.ParametroService;

public class NotificacionUtil {
	public static void cargaNotificacionesPaciente(Model model, Paciente paciente,
			NotificacionpacienteService notificacionpacienteService, ParametroService parametroService) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Notificacionpaciente> notificaciones = notificacionpacienteService
				.findByPacienteAndParamEstadoNotificacion(paciente, parametro);
		formatNotificacion(notificaciones);
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

	public static void cambiaEstadoNotificacionPodologo(Model model, Podologo podologo,
			NotificacionpodologoService notificacionpodologoService, ParametroService parametroService, int id) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		Notificacionpodologo notificacion = notificacionpodologoService.findByIdAndPodologo(id, podologo);
		if (notificacion != null) {
			notificacion.setParamEstadoNotificacion(parametro);
			notificacionpodologoService.save(notificacion);
		}
		cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
	}

	private static void formatNotificacion(List<Notificacionpaciente> notificaciones) {
		for (Notificacionpaciente notificacionpaciente : notificaciones) {
			if (notificacionpaciente.getTitulo().length() > 25) {
				notificacionpaciente.setTitulo(notificacionpaciente.getTitulo().substring(0, 24) + "...");
			}
		}
	}

	private static void formatNotificacionPodologo(List<Notificacionpodologo> notificaciones) {
		for (Notificacionpodologo notificacionpodologo : notificaciones) {
			if (notificacionpodologo.getTitulo().length() > 25) {
				notificacionpodologo.setTitulo(notificacionpodologo.getTitulo().substring(0, 24) + "...");
			}
		}
	}

	public static void cargaNotificacionesPodologo(Model model, Podologo podologo,
			NotificacionpodologoService notificacionpodologoService, ParametroService parametroService) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Notificacionpodologo> notificaciones = notificacionpodologoService
				.findByPodologoAndParamEstadoNotificacion(podologo, parametro);
		formatNotificacionPodologo(notificaciones);
		model.addAttribute("notificaciones", notificaciones);
	}
}
