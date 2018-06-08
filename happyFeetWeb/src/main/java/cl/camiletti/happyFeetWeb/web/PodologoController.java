package cl.camiletti.happyFeetWeb.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Atencion;
import cl.camiletti.happyFeetWeb.model.Cuestionariopodologo;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Notificacionpaciente;
import cl.camiletti.happyFeetWeb.model.Notificacionpodologo;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;
import cl.camiletti.happyFeetWeb.model.custom.MensajeCustom;
import cl.camiletti.happyFeetWeb.service.AgendaService;
import cl.camiletti.happyFeetWeb.service.AtencionService;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.CuestionariopacienteService;
import cl.camiletti.happyFeetWeb.service.CuestionariopodologoService;
import cl.camiletti.happyFeetWeb.service.EvaluacionService;
import cl.camiletti.happyFeetWeb.service.HorarioService;
import cl.camiletti.happyFeetWeb.service.MensajeService;
import cl.camiletti.happyFeetWeb.service.NotificacionpacienteService;
import cl.camiletti.happyFeetWeb.service.NotificacionpodologoService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.service.SolicitudAtencionService;
import cl.camiletti.happyFeetWeb.service.UbicacionService;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.Constantes;
import cl.camiletti.happyFeetWeb.util.DateUtil;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;
import cl.camiletti.happyFeetWeb.util.Mail;
import cl.camiletti.happyFeetWeb.util.MensajesNuevosUtil;
import cl.camiletti.happyFeetWeb.util.NotificacionPacienteConstantes;
import cl.camiletti.happyFeetWeb.util.NotificacionUtil;
import cl.camiletti.happyFeetWeb.util.Parametros;

@Controller
@SessionAttributes(value = { "podologo", "paciente", "atencion", "pacientes", "solicitudes", "agendaParaFinalizar",
		"solicitudAtencion", "mensajesNuevos", "notificaciones","cuestionarioParaFinalizar" })
public class PodologoController {
	@Autowired
	private PodologoService podologoService;
	@Autowired
	private EvaluacionService evaluacionService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private AtencionService atencionService;

	@Autowired
	private MensajeService mensajeService;

	@Autowired
	private ComunaService comunaService;

	@Autowired
	private DateUtil utilDate;

	@Autowired
	private SolicitudAtencionService solicitudAtencionService;

	@Autowired
	private Environment env;

	@Autowired
	private UbicacionService ubicacionService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DateUtil dateUtil;

	@Autowired
	private HorarioService horarioService;

	@Autowired
	private AgendaService agendaService;
	@Autowired
	private CuestionariopacienteService cuestionariopacienteService;
	@Autowired
	private CuestionariopodologoService cuestionariopodologoService;
	@Autowired
	private NotificacionpodologoService notificacionpodologoService;
	@Autowired
	private NotificacionpacienteService notificacionpacienteService;

	@RequestMapping(value = "/podologo/index", method = RequestMethod.GET)
	public String redirect(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Podologo podologo = podologoService.findByEmail(user.getUsername());
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		model.addAttribute("podologo", podologo);
		return "podologo/podologo";
	}

	@RequestMapping(value = "/podologo/miAgenda", method = RequestMethod.GET)
	public String ingresarHora(Model model, @ModelAttribute("podologo") Podologo podologo) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		model.addAttribute("horarios", horarioService.findByPodologo(podologo));
		model.addAttribute("estadosHorario", parametroService.findByNumero(Parametros.ESTADO_HORARIO));
		return "podologo/miAgenda";
	}

	@RequestMapping(value = "/podologo/misSolicitudes", method = RequestMethod.GET)
	public String verSolicitudes(@ModelAttribute("podologo") Podologo podologo, Model model) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_PENDIENTE);
		List<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(parametro);
		List<Solicitudatencion> solicitudes = solicitudAtencionService.findByParamEstadoSolicitudAtencion(parametro,
				podologo);
		model.addAttribute("solicitudesPendientes", solicitudes);
		solicitudes = solicitudAtencionService.findByPodologoAndParamEstadoSolicitudAtencionNotIn(podologo, parametros);
		model.addAttribute("solicitudes", solicitudes);
		return "podologo/solicitudes";
	}

	@RequestMapping(value = "/podologo/misAtenciones", method = RequestMethod.GET)
	public String misAtenciones(Model model, @ModelAttribute("podologo") Podologo podologo) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_AGENDA_PENDIENTE);
		List<Agenda> atencionesPendientes = agendaService.findByPodologoAndParamEstadoAgenda(podologo, parametro);
		parametro = parametroService.findOne(Parametros.ESTADO_AGENDA_ACEPTADA);
		List<Agenda> atencionesRealizadas = agendaService.findByPodologoAndParamEstadoAgenda(podologo, parametro);
		model.addAttribute("atencionesPendientes", atencionesPendientes);
		model.addAttribute("atencionesRealizadas", atencionesRealizadas);
		return "podologo/atenciones";
	}

	@RequestMapping(value = "/podologo/misEvaluaciones", method = RequestMethod.GET)
	public String misEvaluaciones(Model model, @ModelAttribute("podologo") Podologo podologo) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		List<Evaluacion> evaluaciones = evaluacionService.findByPodologo(podologo);
		model.addAttribute("evaluaciones", evaluaciones);
		return "podologo/evaluaciones";
	}
	@RequestMapping(value = "/podologo/solicitudAtencionNotificacion", method = RequestMethod.GET)
	public String solicitudAtencionNotificacion(@ModelAttribute("podologo") Podologo podologo, Model model,
			@RequestParam("idNotificacion") int idNotificacion, @RequestParam("id") int id) {
		NotificacionUtil.cambiaEstadoNotificacionPodologo(model, podologo, notificacionpodologoService,
				parametroService, idNotificacion);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Solicitudatencion solicitud = solicitudAtencionService.findById(id);
		model.addAttribute("solicitudAtencion", solicitud);
		return "podologo/detalleSolicitud";
	}

	@RequestMapping(value = "/podologo/verAtencionEvaluada", method = RequestMethod.GET)
	public String verAtencionEvaluada(Model model, @ModelAttribute("podologo") Podologo podologo,
			@RequestParam("idEvaluacion") int id) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Evaluacion evaluacion = evaluacionService.findById(id);
		Atencion atencion = atencionService.findByEvaluacion(evaluacion);
		model.addAttribute("atencion", atencion);
		return "podologo/verAtencion";

	}

	@RequestMapping(value = "/podologo/misNotificaciones", method = RequestMethod.GET)
	public String misNotificaciones(Model model, @ModelAttribute("podologo") Podologo podologo) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		List<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(parametro);
		List<Notificacionpodologo> notificaciones = notificacionpodologoService
				.findByPodologoAndParamEstadoNotificacionNotIn(podologo, parametros);
		model.addAttribute("notificacionesPendientes", notificaciones);
		parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		notificaciones = notificacionpodologoService.findByPodologoAndParamEstadoNotificacion(podologo, parametro);
		model.addAttribute("notificacionesVistas", notificaciones);
		return "podologo/notificaciones";
	}

	@RequestMapping(value = "/podologo/misMensajes", method = RequestMethod.GET)
	public String misMensajes(Model model, @ModelAttribute("podologo") Podologo podologo) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Mensaje> mensajesNoVistos = mensajeService.findByReceptorRutAndParamEstadoMensaje(podologo.getRut(),
				parametro);
		model.addAttribute("mensajesSinVer",
				MensajeCustom.cargarMensajesNoVistosPodologo(mensajesNoVistos, pacienteService, podologoService));
		parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		List<Mensaje> mensajesVistos = mensajeService.findByReceptorRutAndParamEstadoMensaje(podologo.getRut(),
				parametro);
		model.addAttribute("mensajesVistos", MensajeCustom.cargarMensajesVistosPodologo(mensajesNoVistos,
				pacienteService, podologoService, mensajesVistos));
		return "podologo/mensajes";
	}

	/*
	 * @RequestMapping(value = "/podologo/pacientes", method = RequestMethod.GET)
	 * public String cargarPacientes(Model model, @ModelAttribute("podologo")
	 * Podologo podologo) { List<Agenda> agendas =
	 * agendaService.findByPodologo(podologo); ArrayList<Paciente> pacientes = new
	 * ArrayList<>(); for (int i = 0; i < agendas.size(); i++) { if
	 * (!pacientes.contains(agendas.get(i).getPaciente()))
	 * pacientes.add(agendas.get(i).getPaciente()); }
	 * 
	 * pacientes = (ArrayList<Paciente>)
	 * pacientes.stream().distinct().collect(Collectors.toList());
	 * utilDate.setEdad(pacientes); model.addAttribute("pacientes", pacientes);
	 * model.addAttribute("podologo", podologo); return "podologo/pacientes"; }
	 * 
	 * @RequestMapping(value = "/podologo/buscarPacientes", method =
	 * RequestMethod.POST) public String buscarPaciente(@ModelAttribute("podologo")
	 * Podologo podologo, Model model,
	 * 
	 * @RequestParam("selectBuscar") String
	 * criterioBusqueda, @RequestParam("textBuscar") String textBuscar) {
	 * 
	 * ArrayList<Paciente> pacientes = new ArrayList(); String mensaje = ""; if
	 * (criterioBusqueda.equals("Nombre")) { pacientes = (ArrayList<Paciente>)
	 * pacienteService.findByNombre(textBuscar); } else { if
	 * (criterioBusqueda.equals("Rut")) {
	 * pacientes.add(pacienteService.find(textBuscar)); pacientes =
	 * (ArrayList<Paciente>)
	 * pacientes.stream().distinct().collect(Collectors.toList()); } } if
	 * (pacientes.size() == 0) { mensaje = "No se encontraron resultados"; }
	 * utilDate.setEdad(pacientes); model.addAttribute("mensaje", mensaje);
	 * model.addAttribute("pacientes", pacientes); model.addAttribute("podologo",
	 * podologo);
	 * 
	 * return "podologo/pacientes"; }
	 * 
	 * @RequestMapping(value = "/podologo/historialPaciente", method =
	 * RequestMethod.GET) public String
	 * cargarHistorialPaciente(@ModelAttribute("podologo") Podologo podologo, Model
	 * model,
	 * 
	 * @RequestParam("rut") String rutPaciente, @ModelAttribute("pacientes")
	 * List<Paciente> pacientes) { Paciente paciente =
	 * pacienteService.find(rutPaciente); List<Atencion> atenciones =
	 * atencionService.findByAgenda(paciente, podologo); podologo =
	 * podologoService.findByEmail(podologo.getEmail());
	 * model.addAttribute("atenciones", atenciones); model.addAttribute("paciente",
	 * paciente); model.addAttribute("podologo", podologo);
	 * model.addAttribute("pacientes", pacientes);
	 * 
	 * return "podologo/historialPaciente"; }
	 */
	@RequestMapping(value = "/podologo/detalleAtencion", method = RequestMethod.GET)
	public String detalleAtencion(@ModelAttribute("paciente") Paciente paciente,
			@ModelAttribute("podologo") Podologo podologo, Model model, @RequestParam("id") int idAtencion,
			@ModelAttribute("pacientes") List<Paciente> pacientes) {

		Atencion atencion = atencionService.findById(idAtencion);
		model.addAttribute("atencion", atencion);
		model.addAttribute("paciente", paciente);
		model.addAttribute("podologo", podologo);
		model.addAttribute("pacientes", pacientes);
		return "podologo/detalleAtencion";
	}

	@RequestMapping(value = "/podologo/diagnostico", method = RequestMethod.GET)
	public String diagnostico(@ModelAttribute("paciente") Paciente paciente,
			@ModelAttribute("podologo") Podologo podologo, @ModelAttribute("atencion") Atencion atencion, Model model,
			@ModelAttribute("pacientes") List<Paciente> pacientes) {
		model.addAttribute("atencion", atencion);
		model.addAttribute("paciente", paciente);
		model.addAttribute("podologo", podologo);
		model.addAttribute("pacientes", pacientes);
		return "podologo/diagnostico";
	}

	@RequestMapping(value = "/podologo/detallePresupesto", method = RequestMethod.GET)
	public String detallePresupuesto(@ModelAttribute("paciente") Paciente paciente,
			@ModelAttribute("podologo") Podologo podologo, @ModelAttribute("atencion") Atencion atencion, Model model) {
		model.addAttribute("detallePresupuesto", atencion.getAgenda().getPresupuesto().getDetallepresupuestos());
		model.addAttribute("presupuesto", atencion.getAgenda().getPresupuesto());
		model.addAttribute("atencion", atencion);
		model.addAttribute("paciente", paciente);
		model.addAttribute("podologo", podologo);
		return "podologo/detallePresupuesto";
	}

	@RequestMapping(value = "/podologo/enviarMensaje", method = RequestMethod.GET)
	public String verMensajes(@ModelAttribute("podologo") Podologo podologo, Model model,
			@RequestParam("rutPaciente") String rutPaciente) {
		Paciente paciente = pacienteService.find(rutPaciente);
		ArrayList<Mensaje> conversacion = (ArrayList<Mensaje>) mensajeService.cargarConversacionPodologo(podologo,
				paciente);
		model.addAttribute("conversacion", conversacion);
		model.addAttribute("paciente", paciente);
		model.addAttribute("mensajeForm", new Mensaje());
		return "podologo/enviarMensaje";
	}

	@RequestMapping(value = "/podologo/enviarMensaje", method = RequestMethod.POST)
	public String enviarMensaje(@ModelAttribute("mensajeForm") Mensaje mensaje,
			@ModelAttribute("paciente") Paciente paciente, @ModelAttribute("podologo") Podologo podologo, Model model) {
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);// hecha
		mensaje.setEmisorRut(podologo.getRut());
		mensaje.setReceptorRut(paciente.getRut());
		mensaje.setParamEstadoMensaje(parametro);
		mensaje.setHora(DateUtil.getHourSystem());
		mensaje.setFecha(DateUtil.getFechaHoyString());
		mensajeService.save(mensaje);
		ArrayList<Mensaje> conversacion = (ArrayList<Mensaje>) mensajeService.cargarConversacionPodologo(podologo,
				paciente);
		model.addAttribute("conversacion", conversacion);
		model.addAttribute("mensajeForm", new Mensaje());
		return "podologo/enviarMensaje";
	}

	@RequestMapping(value = "/podologo/detalleSolicitud", method = RequestMethod.GET)
	public String verDetalleSolicitud(@ModelAttribute("podologo") Podologo podologo, Model model,
			@RequestParam("id") int id) {
		Solicitudatencion solicitudAtencion = solicitudAtencionService.findById(id);
		model.addAttribute("solicitudAtencion", solicitudAtencion);
		return "podologo/detalleSolicitud";
	}

	@RequestMapping(value = "/podologo/modificarSolicitud", method = RequestMethod.POST)
	public String modificarSolicitud(@ModelAttribute("podologo") Podologo podologo,
			@ModelAttribute("solicitudAtencion") Solicitudatencion solicitudAtencion, Model model,
			@RequestParam("respuesta") String respuesta) {
		Parametro parametro = null;
		if (respuesta.equalsIgnoreCase(Constantes.RESPUESTA_SOLICITUD_ATENCION_SI)) {
			parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_ACEPTADA);
			// accepta
			solicitudAtencion.setParamEstadoSolicitudAtencion(parametro);
			// se crea agenda
			Agenda agenda = new Agenda();
			agenda.setHorario(solicitudAtencion.getHorario());
			agenda.setPaciente(solicitudAtencion.getPaciente());
			agenda.setPodologo(solicitudAtencion.getPodologo());
			agenda.setParamEstadoAgenda(parametroService.findOne(Parametros.ESTADO_AGENDA_PENDIENTE));
			agenda.setFotoPiePath(solicitudAtencion.getFotoPiePath());
			agenda.setPatologia(solicitudAtencion.getPatologia());
			agenda.setPresupuesto(solicitudAtencion.getPresupuesto());
			agenda.setFechaAgenda(DateUtil.getFechaHoyString());
			agenda.setFotoViajePath(solicitudAtencion.getFotoViajePath());
			// se crea agenda
			solicitudAtencionService.save(solicitudAtencion);
			agendaService.save(agenda);
			model.addAttribute("mensaje", "Solicitud Aceptada con Éxito");

			parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
			Notificacionpaciente notificacionpaciente = new Notificacionpaciente();
			notificacionpaciente.setPaciente(solicitudAtencion.getPaciente());
			notificacionpaciente.setParamEstadoNotificacion(parametro);
			notificacionpaciente.setUrl(NotificacionPacienteConstantes.SOLICITUD_ATENCION + solicitudAtencion.getId());
			notificacionpaciente.setTitulo(NotificacionPacienteConstantes.TITULO_SOLICITUD_ATENCION_ACEPTADA);
			notificacionpaciente.setMensaje(solicitudAtencion.getPodologo().getNombres()
					+ NotificacionPacienteConstantes.MSG_SOLICITUD_ATENCION);
			notificacionpaciente.setFecha(DateUtil.getFechaHoyString());
			notificacionpaciente.setHora(DateUtil.getHourSystem());
			notificacionpacienteService.save(notificacionpaciente);

			// accepta
		} else {
			if (respuesta.equalsIgnoreCase(Constantes.RESPUESTA_SOLICITUD_ATENCION_NO)) {
				parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_RECHAZADA);
				solicitudAtencion.setParamEstadoSolicitudAtencion(parametro);
				solicitudAtencionService.save(solicitudAtencion);

				parametro = parametroService.findOne(Parametros.ESTADO_HORARIO_DISPONIBLE);
				Horario horario = solicitudAtencion.getHorario();
				horario.setParamEstadoHorario(parametro);
				horarioService.save(horario);
				
				if(solicitudAtencion.getPresupuesto().getCuestionarioPaciente()!=null) {
					parametro = parametroService.findOne(Parametros.ESTADO_DESCUENTO_DISPONIBLE);
					solicitudAtencion.getPresupuesto().getCuestionarioPaciente().setParamEstadoDescuento(parametro);
					cuestionariopacienteService.save(solicitudAtencion.getPresupuesto().getCuestionarioPaciente());
				}
				model.addAttribute("mensaje", "Solicitud Rechazada con Éxito");

				parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
				Notificacionpaciente notificacionpaciente = new Notificacionpaciente();
				notificacionpaciente.setPaciente(solicitudAtencion.getPaciente());
				notificacionpaciente.setParamEstadoNotificacion(parametro);
				notificacionpaciente
						.setUrl(NotificacionPacienteConstantes.SOLICITUD_ATENCION + solicitudAtencion.getId());
				notificacionpaciente.setTitulo(NotificacionPacienteConstantes.TITULO_SOLICITUD_ATENCION_RECHAZADA);
				notificacionpaciente.setMensaje(solicitudAtencion.getPodologo().getNombres()
						+ NotificacionPacienteConstantes.MSG_SOLICITUD_ATENCION);
				notificacionpaciente.setFecha(DateUtil.getFechaHoyString());
				notificacionpaciente.setHora(DateUtil.getHourSystem());
				notificacionpacienteService.save(notificacionpaciente);

			} else {
				model.addAttribute("mensaje", "Respuesta de solicitud Incorrecta");
			}
		}
		Mail mail = new Mail(env);
		mail.sendEmailRespuestaSolicitudAtencion(solicitudAtencion.getPaciente().getEmail(),
				solicitudAtencion.getPaciente().getNombres() + " " + solicitudAtencion.getPaciente().getApellidos());

		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_PENDIENTE);
		List<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(parametro);
		List<Solicitudatencion> solicitudes = solicitudAtencionService.findByParamEstadoSolicitudAtencion(parametro,
				podologo);
		model.addAttribute("solicitudesPendientes", solicitudes);
		solicitudes = solicitudAtencionService.findByPodologoAndParamEstadoSolicitudAtencionNotIn(podologo, parametros);
		model.addAttribute("solicitudes", solicitudes);
		return "podologo/solicitudes";
	}

	@RequestMapping(value = "/podologo/modificarDatos", method = RequestMethod.GET)
	public String modificar(Model model, @ModelAttribute("podologo") Podologo podologo) {
		podologo.getUsuario().setPassword("");
		podologo.getUsuario().setPasswordConfirm("");
		model.addAttribute("podologoForm", podologo);

		model.addAttribute("ubicacion", podologo.getUbicacion().getNombre());
		model.addAttribute("comuna", podologo.getUbicacion().getComuna().getNombre());
		model.addAttribute("paramSexo", podologo.getParamSexo());
		model.addAttribute("usuario", podologo.getUsuario());
		model.addAttribute("sexos", parametroService.findByNumero(44));
		model.addAttribute("comunas", comunaService.findAll());
		return "podologo/modificar";
	}

	@RequestMapping(value = "/podologo/modificarDatos", method = RequestMethod.POST)
	public String modificarpost(@ModelAttribute("podologoForm") Podologo podologoForm,
			@ModelAttribute("podologo") Podologo podologo, BindingResult bindingResult, Model model,
			@RequestParam("archivo") MultipartFile archivo) {
		if (bindingResult.hasErrors()) {

		} else {
			FileManagerUtil fileManagerUtil = new FileManagerUtil();
			if (podologo.getUsuario().getPassword().equals(podologoForm.getUsuario().getPassword()) && podologo
					.getUsuario().getPasswordConfirm().equals(podologoForm.getUsuario().getPasswordConfirm())) {
				
				/*
					if (!podologoForm.getUbicacion().getLatitud().equals(podologo.getUbicacion().getLatitud())
						|| !podologoForm.getUbicacion().getLongitud().equals(podologo.getUbicacion().getLongitud())) {
					podologo.setUbicacion(podologoForm.getUbicacion());
				}
				 * 
				 * */
				podologo.getUbicacion().setLatitud(podologoForm.getUbicacion().getLatitud());
				podologo.getUbicacion().setNombre(podologoForm.getUbicacion().getNombre());
				podologo.getUbicacion().setLongitud(podologoForm.getUbicacion().getLongitud());
				podologo.getUbicacion().getComuna().setId(podologoForm.getUbicacion().getComuna().getId());
				podologo.setFono(podologoForm.getFono());
				if (!archivo.isEmpty()) {
					String file = fileManagerUtil.getBase64FromFoto(archivo);
					podologo.setFoto(file);
				}
				podologoService.save(podologo);
				model.addAttribute("mensaje", "Sus datos fueron guardados con éxito");
			} else {
				model.addAttribute("mensajeError", "Contraseña Incorrecta");
			}

		}
		model.addAttribute("podologo", podologo);
		return "podologo/podologo";
	}

	@RequestMapping(value = "/podologo/buscarSolicitudes", method = RequestMethod.POST)
	public String buscarSolicitud(@ModelAttribute("podologo") Podologo podologo,
			@ModelAttribute("solicitudes") List<Solicitudatencion> solicitudes, Model model,
			@RequestParam("fechaBusqueda") String fechaBusqueda) {
		ArrayList<Solicitudatencion> solicitudesEncontradas = new ArrayList();
		for (Solicitudatencion solicitudatencion : solicitudes) {
			if (fechaBusqueda.equals(solicitudatencion.getHorario().getFecha()))
				solicitudesEncontradas.add(solicitudatencion);
		}
		String mensaje = null;
		if (solicitudesEncontradas.isEmpty()) {
			mensaje = "No se encontraron resultados";
		}

		model.addAttribute("solicitudesEncontradas", solicitudesEncontradas);
		model.addAttribute("podologo", podologo);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("solicitudes", solicitudes);
		return "podologo/verSolicitudesPendientes";
	}

	@RequestMapping(value = "/podologo/ingresarHora", method = RequestMethod.POST)
	public String miAgenda(Model model,
			@RequestParam("diaAgenda") @DateTimeFormat(pattern = "dd/MM/yyyy") String diaAgenda,
			@RequestParam("horaInicioAgenda") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSSZ") String horaInicio,
			@RequestParam("horaFinAgenda") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSSZ") String horaFin,
			@RequestParam("estadoHorario") int estadoHorario) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Podologo podologo = podologoService.findByEmail(user.getUsername());
		Parametro param = parametroService.findOne(estadoHorario);
		Agenda agenda = new Agenda();
		Horario horario = new Horario();
		horario.setFecha(dateUtil.formatearFecha(diaAgenda));
		horario.setHora(horaInicio);
		horario.setHoraFin(horaFin);
		horario.setParamEstadoHorario(param);
		horario.setPodologo(podologo);
		agenda.setHorario(horario);
		horarioService.save(horario);
		agendaService.save(agenda);
		model.addAttribute("estadosHorario", parametroService.findByNumero(22));
		model.addAttribute("horarios", horarioService.findByPodologo(podologo));
		return "podologo/miAgenda";
	}

	@RequestMapping(value = "/podologo/eliminarHorario", method = RequestMethod.GET)
	public String eliminarHorario(Model model, @RequestParam("id") int horarioId) {
		Horario horario = new Horario();
		horario.setId(horarioId);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Podologo podologo = podologoService.findByEmail(user.getUsername());
		horarioService.deleteById(horario);
		model.addAttribute("estadosHorario", parametroService.findByNumero(22));
		model.addAttribute("horarios", horarioService.findByPodologo(podologo));
		return "podologo/miAgenda";
	}

	@RequestMapping(value = "/podologo/modificarHorario", method = RequestMethod.GET)
	public String modificarHorarioGet(Model model, @RequestParam("id") int horarioId) {
		model.addAttribute("horarioAModifcar", horarioService.findById(horarioId));
		model.addAttribute("estadosHorario", parametroService.findByNumero(22));
		return "podologo/modificarHorario";
	}

	@RequestMapping(value = "/podologo/modificarHorario", method = RequestMethod.POST)
	public String modificarHorarioPost(Model model, @ModelAttribute("horarioAModifcar") Horario horario) {
		horario.setFecha(dateUtil.formatearFecha(horario.getFecha()));
		horarioService.save(horario);
		model.addAttribute("mensaje", "Horario modificado con éxito");
		model.addAttribute("estadosHorario", parametroService.findByNumero(22));
		model.addAttribute("horarios", horarioService.findByPodologo(horario.getPodologo()));
		return "podologo/miAgenda";
	}

	@RequestMapping(value = "/podologo/buscarHorario", method = RequestMethod.POST)
	public String buscarHorario(Model model,
			@RequestParam("diaAgenda") @DateTimeFormat(pattern = "dd/MM/yyyy") String diaAgenda) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Podologo podologo = podologoService.findByEmail(user.getUsername());
		model.addAttribute("estadosHorario", parametroService.findByNumero(22));
		model.addAttribute("horarios",
				horarioService.findByFechaAndPodologo(dateUtil.formatearFecha(diaAgenda), podologo));
		return "podologo/miAgenda";
	}

	@RequestMapping(value = "/podologo/detalleSolicitudAtendida", method = RequestMethod.GET)
	public String verAtenciones(Model model, @ModelAttribute("podologo") Podologo podologo,
			@RequestParam("id") int solicitudId) {
		Solicitudatencion solicitudAtencion = solicitudAtencionService.findById(solicitudId);
		Agenda agenda = new Agenda();
		Atencion atencion = new Atencion();
		// no se ocupa este metodo
		agenda.setFotoPiePath(solicitudAtencion.getFotoPiePath());
		agenda.setPaciente(solicitudAtencion.getPaciente());
		return "podologo/atenciones";
	}

	@RequestMapping(value = "/podologo/atencionesPendientes", method = RequestMethod.GET)
	public String atencionesPendientes(Model model, @ModelAttribute("podologo") Podologo podologo) {
		List<Atencion> atencionesAux = null;
		ArrayList<Atencion> atenciones = new ArrayList();
		for (int i = 0; i < atencionesAux.size(); i++) {
			if (atencionesAux.get(i).getAgenda().getParamEstadoAgenda().getValor().equals("Pendiente")) {
				atenciones.add(atencionesAux.get(i));
			}
		}
		model.addAttribute("atenciones", atenciones);
		return "podologo/atenciones";
	}

	@RequestMapping(value = "/podologo/ingresarAtencion", method = RequestMethod.GET)
	public String ingresarAtencion(Model model, @ModelAttribute("podologo") Podologo podologo,
			@RequestParam("id") int id) {
		Agenda agenda = agendaService.findById(id);
		Atencion atencion = new Atencion();
		atencion.setAgenda(agenda);
		model.addAttribute("atencionForm", atencion);
		model.addAttribute("agendaParaFinalizar", agenda);
		return "podologo/guardarAtencion";
	}

	@RequestMapping(value = "/podologo/verAtencion", method = RequestMethod.GET)
	public String verAtencion(Model model, @ModelAttribute("podologo") Podologo podologo, @RequestParam("id") int id) {
		Agenda agenda = agendaService.findById(id);
		Atencion atencion = atencionService.findByAgenda(agenda);
		model.addAttribute("atencion", atencion);
		return "podologo/verAtencion";
	}

	@RequestMapping(value = "/podologo/guardarAtencion", method = RequestMethod.POST)
	public String guardarAtencion(Model model, @ModelAttribute("atencionForm") Atencion atencion,
			@RequestParam("archivo") MultipartFile archivo, @RequestParam("evaluacionStar") String evaluacionStar,
			@ModelAttribute("agendaParaFinalizar") Agenda agenda, @RequestParam("comentario") String comentario) {
		FileManagerUtil fileManagerUtil = new FileManagerUtil();
		if (!archivo.isEmpty()) {
			String file = fileManagerUtil.getBase64FromFoto(archivo);
			atencion.setFoto(file);
		}

		Parametro parametro = parametroService.findOne(Parametros.ESTADO_AGENDA_ACEPTADA);
		agenda.setParamEstadoAgenda(parametro);
		agendaService.save(agenda);

		atencion.setAgenda(agenda);
		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setPodologo(atencion.getAgenda().getPodologo());
		evaluacion.setPaciente(atencion.getAgenda().getPaciente());
		evaluacion.setComentarioPodologo(comentario);
		evaluacion.setValorPaciente(Integer.parseInt(evaluacionStar));
		atencion.setEvaluacion(evaluacion);
		atencionService.save(atencion);

		atencion = atencionService.findByAgenda(agenda);

		parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		Notificacionpaciente notificacionpaciente = new Notificacionpaciente();
		notificacionpaciente.setPaciente(atencion.getAgenda().getPaciente());
		notificacionpaciente.setParamEstadoNotificacion(parametro);
		notificacionpaciente
				.setUrl(NotificacionPacienteConstantes.EVALUAR_PROFESIONAL + atencion.getEvaluacion().getId());
		notificacionpaciente.setTitulo(NotificacionPacienteConstantes.TITULO_EVALUAR_PROFESIONAL);
		notificacionpaciente.setMensaje(NotificacionPacienteConstantes.MSG_EVALUAR_PROFESIONAL
				+ atencion.getAgenda().getPodologo().getNombres());
		notificacionpaciente.setFecha(DateUtil.getFechaHoyString());
		notificacionpaciente.setHora(DateUtil.getHourSystem());
		notificacionpacienteService.save(notificacionpaciente);
		Mail mail = new Mail(env);
		mail.sendEmailFinalizarAtencion(agenda.getPaciente().getEmail(),
				agenda.getPaciente().getNombres() + " " + agenda.getPaciente().getApellidos());
		
		model.addAttribute("mensaje", "Atención Finalizada con Éxito");
		return "podologo/podologo";
	}
	@RequestMapping(value = "/podologo/cuestionarios", method = RequestMethod.GET)
	public String cuestionarios(Model model, @ModelAttribute("podologo") Podologo podologo) {
		NotificacionUtil.cargaNotificacionesPodologo(model, podologo, notificacionpodologoService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPodologo(model, podologo, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_PENDIENTE);
		List<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(parametro);
		List<Cuestionariopodologo> cuestionarios = cuestionariopodologoService
				.findByPodologoAndParamEstadoCuestionarioIn(podologo, parametros);
		model.addAttribute("cuestionariosPendientes", cuestionarios);
		parametros = new ArrayList<Parametro>();
		parametros.add(parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_RESUELTO));
		cuestionarios = cuestionariopodologoService.findByPodologoAndParamEstadoCuestionarioIn(podologo, parametros);
		model.addAttribute("cuestionariosRealizados", cuestionarios);
		return "podologo/cuestionarios";
	}
	@RequestMapping(value = "/podologo/verCuestionario", method = RequestMethod.GET)
	public String verCuestionario(Model model, @RequestParam("id") int id) {
		Cuestionariopodologo cuestionariopodologo = cuestionariopodologoService.findById(id);
		model.addAttribute("cuestionariopodologo", cuestionariopodologo);
		model.addAttribute("cuestionarioParaFinalizar", cuestionariopodologo);
		return "podologo/verCuestionario";
	}

	@RequestMapping(value = "/podologo/guardarCuestionario", method = RequestMethod.POST)
	public String guardarCuestionario(Model model, @RequestParam("respuestaUno") String respuestaUno,
			@RequestParam("respuestaDos") String respuestaDos, @RequestParam("respuestaTres") String respuestaTres,
			@ModelAttribute("cuestionarioParaFinalizar") Cuestionariopodologo cuestionariopodologo) {
		cuestionariopodologo
				.setParamEstadoCuestionario(parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_RESUELTO));
		cuestionariopodologo.setParamEstadoDescuento(parametroService.findOne(Parametros.ESTADO_DESCUENTO_DISPONIBLE));
		cuestionariopodologo.setRespuesta_uno(respuestaUno);
		cuestionariopodologo.setRespuesta_dos(respuestaDos);
		cuestionariopodologo.setRespuesta_tres(respuestaTres);
		cuestionariopodologoService.save(cuestionariopodologo);
		model.addAttribute("mensaje", "Encuesta guardada con éxito, puede seguir ofreciendo sus Servicios");
		return "podologo/podologo";
	}
}
