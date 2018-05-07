package cl.camiletti.happyFeetWeb.util;

import java.util.List;

import org.springframework.ui.Model;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.service.MensajeService;
import cl.camiletti.happyFeetWeb.service.ParametroService;

public class MensajesNuevosUtil {
	public static void cargaMensajesNuevosPaciente(Model model, Paciente paciente, MensajeService mensajeService,
			ParametroService parametroService) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Mensaje> mensajes = mensajeService.findByReceptorRutAndParamEstadoMensaje(paciente.getRut(), parametro);
		formatMensaje(mensajes);
		model.addAttribute("mensajesNuevos", mensajes);
	}

	public static void cambiaEstadoMensajeNuevo(Model model, Paciente paciente, MensajeService mensajeService,
			ParametroService parametroService, int id) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		Mensaje mensaje = mensajeService.findById(id);
		if (mensaje != null) {
			mensaje.setParamEstadoMensaje(parametro);
			mensajeService.save(mensaje);
		}
		cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
	}

	private static void formatMensaje(List<Mensaje> mensajes) {
		for (Mensaje mensaje : mensajes) {
			if (mensaje.getCuerpo().length() > 25) {
				mensaje.setCuerpo(mensaje.getCuerpo().substring(0, 24) + "...");
			}
		}
	}
	
	public static void cargaMensajesNuevosPodologo(Model model, Podologo podologo, MensajeService mensajeService,
			ParametroService parametroService) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Mensaje> mensajes = mensajeService.findByReceptorRutAndParamEstadoMensaje(podologo.getRut(), parametro);
		formatMensaje(mensajes);
		model.addAttribute("mensajesNuevos", mensajes);
	}
}
