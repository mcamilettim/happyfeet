package cl.camiletti.happyFeetWeb.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Presupuesto;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.model.custom.MensajeCustomPaciente;
import cl.camiletti.happyFeetWeb.service.AgendaService;
import cl.camiletti.happyFeetWeb.service.AtencionService;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.EvaluacionService;
import cl.camiletti.happyFeetWeb.service.HorarioService;
import cl.camiletti.happyFeetWeb.service.MensajeService;
import cl.camiletti.happyFeetWeb.service.NotificacionpacienteService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.PatologiaService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.service.SecurityService;
import cl.camiletti.happyFeetWeb.service.SolicitudAtencionService;
import cl.camiletti.happyFeetWeb.service.UbicacionService;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.Constantes;
import cl.camiletti.happyFeetWeb.util.DateUtil;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;
import cl.camiletti.happyFeetWeb.util.Mail;
import cl.camiletti.happyFeetWeb.util.MensajesNuevosUtil;
import cl.camiletti.happyFeetWeb.util.NotificacionUtil;
import cl.camiletti.happyFeetWeb.util.Parametros;
import cl.camiletti.happyFeetWeb.util.Seccion;

@Controller
@SessionAttributes(value = { "sessionUser", "paciente", "notificaciones", "atencionParaFinalizar", "podologo","patologia"})
public class PacienteController {
	@Autowired
	PodologoService podologoService;
	@Autowired
	SolicitudAtencionService solicitudAtencionService;
	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ComunaService comunaService;

	@Autowired
	private UbicacionService ubicacionService;

	@Autowired
	HorarioService horarioService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private MensajeService mensajeService;
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AgendaService agendaService;

	@Autowired
	private AtencionService atencionService;

	@Autowired
	private DateUtil dateUtil;

	@Autowired
	private Environment env;

	@Autowired
	private NotificacionpacienteService notificacionpacienteService;

	@Autowired
	private PatologiaService patologiaService;
	@Autowired
	private EvaluacionService evaluacionService;

	@RequestMapping(value = "/paciente/index", method = RequestMethod.GET)
	public String redirect(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		model.addAttribute("paciente", paciente);
		return "paciente/paciente";
	}

	@RequestMapping(value = "/paciente/quizPatologia", method = RequestMethod.GET)
	public String solicitud(Model model,@ModelAttribute("paciente") Paciente paciente) {
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		List<Patologia> patologias = patologiaService.findAll();
		model.addAttribute("patologias", patologias);
		return "paciente/quiz";
	}
	@RequestMapping(value = "/paciente/selectPodologo", method = RequestMethod.GET)
	public String seleccionaPatologia(Model model, @RequestParam("id") int id) {
		Patologia patologia = patologiaService.findById(id);
		model.addAttribute("patologia", patologia);
		//model.addAttribute("precioPorKilometro", Constantes.VALOR_POR_KILOMETRO);
		model.addAttribute("solicitudForm", new Solicitudatencion());
		return "paciente/seleccionaPodologo";
	}
	@RequestMapping(value = "/paciente/guardarAgenda", method = RequestMethod.POST)
	public String guardarAgenda(Model model, @ModelAttribute("solicitudForm") Solicitudatencion solicitudAtencion,
			@RequestParam("fotoPiePaciente") MultipartFile fotoPiePaciente,
			@RequestParam("kilometros") String kilometros, @RequestParam("urlRuta") String urlRuta,@ModelAttribute("paciente") Paciente paciente,@ModelAttribute("patologia") Patologia patologia) {
		Podologo podologo = podologoService.find(solicitudAtencion.getPodologo().getRut());
		Horario horario = horarioService.findById(solicitudAtencion.getHorario().getId());
				FileManagerUtil fileManagerUtil = new FileManagerUtil();		
		// String fotoPie = fileManagerUtil.subirArchivo(fotoPiePaciente,
		// Seccion.SOLICITUDES_ATENCION, paciente.getRut());
		String fotoPie = fileManagerUtil.getBase64FromFoto(fotoPiePaciente);
		if (solicitudAtencionService.findByHorario(horario) == null) {
			 
			urlRuta = fileManagerUtil.getPathImageFromUrl(urlRuta, paciente.getRut(), podologo.getRut(),
					Seccion.SOLICITUDES_RUTAS, Double.parseDouble(kilometros));
			// saca presupuesto
			Presupuesto presupuesto = new Presupuesto();
			presupuesto.setUbicacionPartida(podologo.getUbicacion());
			presupuesto.setUbicacionLlegada(paciente.getUbicacion());
			presupuesto.setCantidadKM(Double.parseDouble(kilometros));
			presupuesto.setTarifaKM(Constantes.VALOR_POR_KILOMETRO);
			presupuesto.setViajePodologo((int) (presupuesto.getTarifaKM() * presupuesto.getCantidadKM()));
			presupuesto.setTotal(presupuesto.getViajePodologo() + patologia.getCosto());

			solicitudAtencion.setPaciente(paciente);
			solicitudAtencion.setPatologia(patologia);
			solicitudAtencion.setPodologo(podologo);
			solicitudAtencion.setHorario(horario);
			solicitudAtencion.setParamEstadoSolicitudAtencion(parametroService.findOne(Parametros.ESTADO_SOLICITUD_PENDIENTE));
			solicitudAtencion.setFechaSolicitud(DateUtil.getFechaHoyString());
			solicitudAtencion.setPresupuesto(presupuesto);
			solicitudAtencion.setFotoPiePath(fotoPie);
			solicitudAtencion.setFotoViajePath(urlRuta);
			solicitudAtencionService.save(solicitudAtencion);
			horario.setParamEstadoHorario(parametroService.findOne(Parametros.ESTADO_HORARIO_TOMADO));
			horarioService.save(horario);
			if (podologo.getParamSexo().getId() == Parametros.ESTADO_SEXO_M)
				model.addAttribute("mensaje",
						"Solicitud de Atención ingresada, el Podólogo responderá a la brevedad... ");
			else
				model.addAttribute("mensaje",
						"Solicitud de Atención ingresada, la Podóloga responderá a la brevedad... ");
		}
		return "paciente/paciente";
	}

	@RequestMapping(value = "/paciente/modificarDatos", method = RequestMethod.GET)
	public String modificardatos(Model model, @ModelAttribute("paciente") Paciente paciente) {
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		paciente.getUsuario().setPassword("");
		paciente.getUsuario().setPasswordConfirm("");
		model.addAttribute("pacienteForm", paciente);
		model.addAttribute("comunas", comunaService.findAll());

		return "paciente/modificar";
	}

	@RequestMapping(value = "/paciente/misAtenciones", method = RequestMethod.GET)
	public String misAtenciones(Model model, @ModelAttribute("paciente") Paciente paciente) {
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_AGENDA_ACEPTADA);// hecha
		List<Agenda> agendas = agendaService.findByPacienteAndParamEstadoAgenda(paciente, parametro);
		model.addAttribute("atencionesRealizadas", agendas);
		parametro = parametroService.findOne(Parametros.ESTADO_AGENDA_PENDIENTE);// pendiente
		agendas = agendaService.findByPacienteAndParamEstadoAgenda(paciente, parametro);
		model.addAttribute("atencionesPendientes", agendas);
		return "paciente/atenciones";
	}

	@RequestMapping(value = "/paciente/misSolicitudes", method = RequestMethod.GET)
	public String misSolicitudes(Model model, @ModelAttribute("paciente") Paciente paciente) {
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		List<Solicitudatencion> solicitudes = solicitudAtencionService.findByPaciente(paciente);
		model.addAttribute("solicitudes", solicitudes);
		model.addAttribute("paciente", paciente);
		return "paciente/solicitudes";
	}

	@RequestMapping(value = "/paciente/misEvaluaciones", method = RequestMethod.GET)
	public String misEvaluaciones(Model model, @ModelAttribute("paciente") Paciente paciente) {
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		List<Evaluacion> evaluaciones = evaluacionService.findByPaciente(paciente);
		model.addAttribute("evaluaciones", evaluaciones);
		evaluaciones = evaluacionService.findByPacienteAndValorPodologo(paciente, 0);
		model.addAttribute("evaluacionesPendientes", evaluaciones);
		return "paciente/evaluaciones";
	}

	@RequestMapping(value = "/paciente/evaluacionNotificacion", method = RequestMethod.GET)
	public String evaluar(@ModelAttribute("paciente") Paciente paciente, Model model,
			@RequestParam("idNotificacion") int idNotificacion,@RequestParam("id") int id) {
		NotificacionUtil.cambiaEstadoNotificacionPaciente(model, paciente, notificacionpacienteService,
				parametroService, idNotificacion);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		
		Evaluacion evaluacion = evaluacionService.findById(id);
		Atencion atencion = atencionService.findByEvaluacion(evaluacion);
		if (evaluacion.getValorPodologo() != 0) {
			model.addAttribute("atencion", atencion);
			model.addAttribute("podologo", evaluacion.getPodologo());
			return "paciente/verAtencion";
		} else {
			model.addAttribute("atencionForm", atencion);
			model.addAttribute("atencionParaFinalizar", atencion);
			return "paciente/guardarAtencion";
		}
	}
	@RequestMapping(value = "/paciente/verAtencionParaEvaluar", method = RequestMethod.GET)
	public String verAtencionParaEvaluar(Model model, @RequestParam("idEvaluacion") int id) {
		Evaluacion evaluacion = evaluacionService.findById(id);
		Atencion atencion = atencionService.findByEvaluacion(evaluacion);
		if (evaluacion.getValorPodologo() != 0) {
			model.addAttribute("atencion", atencion);
			model.addAttribute("podologo", evaluacion.getPodologo());
			return "paciente/verAtencion";
		} else {
			model.addAttribute("atencionForm", atencion);
			model.addAttribute("atencionParaFinalizar", atencion);
			return "paciente/guardarAtencion";
		}
	}
	@RequestMapping(value = "/paciente/misMensajes", method = RequestMethod.GET)
	public String misMensajes(Model model, @ModelAttribute("paciente") Paciente paciente) {
		NotificacionUtil.cargaNotificacionesPaciente(model, paciente, notificacionpacienteService, parametroService);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_NO_VISTO);
		List<Mensaje> mensajesNoVistos = mensajeService.findByReceptorRutAndParamEstadoMensaje(paciente.getRut(),
				parametro);
		model.addAttribute("mensajesSinVer",
				MensajeCustomPaciente.cargarMensajesNoVistos(mensajesNoVistos, pacienteService, podologoService));
		parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);
		List<Mensaje> mensajesVistos = mensajeService.findByReceptorRutAndParamEstadoMensaje(paciente.getRut(),
				parametro);
		model.addAttribute("mensajesVistos", MensajeCustomPaciente.cargarMensajesVistos(mensajesNoVistos,
				pacienteService, podologoService, mensajesVistos));
		return "paciente/mensajes";
	}

	@RequestMapping(value = "/paciente/enviarMensaje", method = RequestMethod.GET)
	public String verMensajes(@ModelAttribute("paciente") Paciente paciente, Model model,
			@RequestParam("rutPodologo") String rutPodologo) {
		Podologo podologo = podologoService.find(rutPodologo);
		ArrayList<Mensaje> conversacion = (ArrayList<Mensaje>) mensajeService.cargarConversacionPaciente(paciente,
				podologo);
		model.addAttribute("conversacion", conversacion);
		model.addAttribute("podologo", podologo);
		model.addAttribute("mensajeForm", new Mensaje());

		Parametro parametro = parametroService.findOne(Parametros.ESTADO_MENSAJE_VISTO);// pendiente
		mensajeService.updateEstadoMensajeVisto(conversacion, parametro);

		return "paciente/enviarMensaje";
	}

	@RequestMapping(value = "/registrarPaciente", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("pacienteForm", new Paciente());
		model.addAttribute("ubicacion", new Ubicacion());
		model.addAttribute("comuna", new Comuna());
		model.addAttribute("paramSexo", new Parametro());
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("sexos", parametroService.findByNumero(44));
		model.addAttribute("comunas", comunaService.findAll());

		return "paciente/registrar";
	}

	@RequestMapping(value = "/paciente/enviarMensaje", method = RequestMethod.POST)
	public String enviarMensaje(@ModelAttribute("mensajeForm") Mensaje mensaje,
			@ModelAttribute("paciente") Paciente paciente, @ModelAttribute("podologo") Podologo podologo, Model model) {

		mensaje.setReceptorRut(podologo.getRut());
		mensaje.setEmisorRut(paciente.getRut());
		mensajeService.save(mensaje);
		ArrayList<Mensaje> conversacion = (ArrayList<Mensaje>) mensajeService.cargarConversacionPodologo(podologo,
				paciente);
		model.addAttribute("conversacion", conversacion);
		model.addAttribute("mensajeForm", new Mensaje());
		return "paciente/enviarMensaje";
	}

	@RequestMapping(value = "/registrarPaciente", method = RequestMethod.POST)
	public String registration(@ModelAttribute("pacienteForm") Paciente pacienteForm, BindingResult bindingResult,
			Model model, @RequestParam("fotoPerfil") MultipartFile fotoPerfilPath) {
		if (bindingResult.hasErrors()) {

		} else {
			pacienteForm.setRut(pacienteForm.getRut().replace(".", ""));
			FileManagerUtil fileManagerUtil = new FileManagerUtil();
			String fotoPerfil = fileManagerUtil.getBase64FromFoto(fotoPerfilPath);
			if (fotoPerfil != null)
				pacienteForm.setFoto(fotoPerfil);
			if (usuarioService.findByEmail(pacienteForm.getEmail()) == null) {
				if (ubicacionService.findByNombre(pacienteForm.getUbicacion().getNombre()) == null) {
					ubicacionService.save(pacienteForm.getUbicacion());
				}
				Usuario user = new Usuario();
				user.setEmail(pacienteForm.getEmail());
				user.setPassword(pacienteForm.getUsuario().getPassword());
				user.setPasswordConfirm(pacienteForm.getUsuario().getPasswordConfirm());
				usuarioService.save(user);

				pacienteForm.setUsuario(usuarioService.findByEmail(pacienteForm.getEmail()));
				pacienteForm.setUbicacion(ubicacionService.findByNombre(pacienteForm.getUbicacion().getNombre()));
				pacienteForm.getUsuario().setParamTipoUsuario(parametroService.findOne(17));
				pacienteForm.setEdad(dateUtil.getAge(pacienteForm.getFechaNacimiento()));
				pacienteForm.setParamSexo(parametroService.findOne(pacienteForm.getParamSexo().getId()));

				usuarioService.save(pacienteForm.getUsuario());
				pacienteService.save(pacienteForm);
				Mail mail = new Mail(env);
				mail.sendEmailBienvenidoPaciente(pacienteForm.getEmail(),
						pacienteForm.getNombres() + " " + pacienteForm.getApellidos());
				model.addAttribute("mensaje", "Paciente registrado con exito.");
			} else {
				model.addAttribute("mensaje", "Este email se encuentra registrado. Inicie sesión.");
			}
			return "login";
		}
		return "paciente/registrar";
	}

	@RequestMapping(value = "/paciente/modificarDatos", method = RequestMethod.POST)
	public String modificarpost(@ModelAttribute("pacienteForm") Paciente pacienteForm,
			@RequestParam("archivo") MultipartFile archivo,@ModelAttribute("paciente") Paciente paciente, BindingResult bindingResult, Model model) {

		FileManagerUtil fileManagerUtil = new FileManagerUtil();
		if (bindingResult.hasErrors()) {

		} else {
			// Mail mail = new Mail(env);
			if (paciente.getUsuario().getPassword().equals(pacienteForm.getUsuario().getPassword()) && paciente
					.getUsuario().getPasswordConfirm().equals(pacienteForm.getUsuario().getPasswordConfirm())) {
				paciente.getUbicacion().setLatitud(pacienteForm.getUbicacion().getLatitud());
				paciente.getUbicacion().setNombre(pacienteForm.getUbicacion().getNombre());
				paciente.getUbicacion().setLongitud(pacienteForm.getUbicacion().getLongitud());
				paciente.getUbicacion().getComuna().setId(pacienteForm.getUbicacion().getComuna().getId());
				paciente.setFono(pacienteForm.getFono());
				if (!archivo.isEmpty()) {
					String file = fileManagerUtil.getBase64FromFoto(archivo);
					paciente.setFoto(file);
				}
				pacienteService.save(paciente);
				model.addAttribute("mensaje", "Sus datos fueron guardados con éxito");
			} else {
				model.addAttribute("mensajeError", "Contraseña Incorrecta");
			}
		}
		model.addAttribute("paciente", paciente);
		return "paciente/paciente";
	}

	@RequestMapping(value = "/paciente/detalleSolicitud", method = RequestMethod.GET)
	public String detalleSolicitud(Model model,
			@RequestParam("id") int id) {
		Solicitudatencion solicitud = solicitudAtencionService.findById(id);
		model.addAttribute("solicitudAtencion", solicitud);
		return "paciente/detalleSolicitud";
	}
	@RequestMapping(value = "/paciente/solicitudAtencionNotificacion", method = RequestMethod.GET)
	public String solicitudAtencionNotificacion(@ModelAttribute("paciente") Paciente paciente, Model model,
			@RequestParam("idNotificacion") int idNotificacion,@RequestParam("id") int id) {
		NotificacionUtil.cambiaEstadoNotificacionPaciente(model, paciente, notificacionpacienteService,
				parametroService, idNotificacion);
		MensajesNuevosUtil.cargaMensajesNuevosPaciente(model, paciente, mensajeService, parametroService);
		Solicitudatencion solicitud = solicitudAtencionService.findById(id);
		model.addAttribute("solicitudAtencion", solicitud);
		return "paciente/detalleSolicitud";
	}

	@RequestMapping(value = "/paciente/detalleAtencion", method = RequestMethod.GET)
	public String detalleAtencion(Model model, @RequestParam("id") int id) {
		Atencion atencion = atencionService.findById(id);
		model.addAttribute("atencion", atencion);
		return "paciente/detalleAtencion";
	}



	@RequestMapping(value = "/paciente/verAtencion", method = RequestMethod.GET)
	public String verAtencion(Model model, @RequestParam("id") int id) {
		Agenda agenda = agendaService.findById(id);
		Atencion atencion = atencionService.findByAgenda(agenda);
		model.addAttribute("atencion", atencion);
		model.addAttribute("podologo", agenda.getPodologo());
		return "paciente/verAtencion";
	}

	@RequestMapping(value = "/paciente/guardarAtencionParaEvaluar", method = RequestMethod.POST)
	public String guardarAtencionParaEvaluar(Model model,
			@ModelAttribute("atencionParaFinalizar") Atencion atencionParaFinalizar,
			@RequestParam("evaluacionStar") String evaluacionStar, @RequestParam("comentario") String comentario) {
		atencionParaFinalizar.getEvaluacion().setComentarioPaciente(comentario);
		atencionParaFinalizar.getEvaluacion().setValorPodologo(Integer.parseInt(evaluacionStar));
		atencionService.save(atencionParaFinalizar);
		model.addAttribute("mensaje", "Evaluación guardada con éxito");
		return "paciente/paciente";
	}




	
}
