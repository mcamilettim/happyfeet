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
import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Presupuesto;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.service.AgendaService;
import cl.camiletti.happyFeetWeb.service.AtencionService;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.HorarioService;
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
import cl.camiletti.happyFeetWeb.util.Parametros;
import cl.camiletti.happyFeetWeb.util.Seccion;

@Controller
@SessionAttributes(value = { "sessionUser", "paciente","pacienteSession" })
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
	private PatologiaService patologiaService;

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

	@RequestMapping(value = "/registrarPaciente", method = RequestMethod.POST)
	public String registration(@ModelAttribute("pacienteForm") Paciente pacienteForm, BindingResult bindingResult,
			Model model, @RequestParam("fotoPerfil") MultipartFile fotoPerfilPath) {
		if (bindingResult.hasErrors()) {

		} else {
			pacienteForm.setRut(pacienteForm.getRut().replace(".", ""));
			FileManagerUtil fileManagerUtil =new FileManagerUtil();
			String fotoPerfil = fileManagerUtil.subirArchivo(fotoPerfilPath, Seccion.PACIENTE, pacienteForm.getRut());
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
				model.addAttribute("mensaje", "Este email se encuentra registrado. Inicie sesi�n.");
			}
			return "login";
		}
		return "paciente/registrar";
	}

	@RequestMapping(value = "/paciente/index", method = RequestMethod.GET)
	public String redirect(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername()); 
		model.addAttribute("paciente", paciente);
		return "paciente/paciente";
	}

	@RequestMapping(value = "/paciente/modificarDatos", method = RequestMethod.GET)
	public String modificardatos(Model model,@ModelAttribute("paciente") Paciente paciente) {
        if(paciente==null)
        	return "paciente/paciente"; 
		paciente.getUsuario().setPassword("");
		paciente.getUsuario().setPasswordConfirm("");
		model.addAttribute("pacienteForm", paciente);
		model.addAttribute("comunas", comunaService.findAll());

		return "paciente/modificar";
	}

	@RequestMapping(value = "/paciente/modificarDatos", method = RequestMethod.POST)
	public String modificarpost(@ModelAttribute("pacienteForm") Paciente pacienteForm,
			@RequestParam("archivo") MultipartFile archivo, BindingResult bindingResult, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		if(paciente==null)
        	return "paciente/paciente"; 
		FileManagerUtil fileManagerUtil =new FileManagerUtil();
		if (bindingResult.hasErrors()) {

		} else {
			//Mail mail = new Mail(env); 
			if(paciente.getUsuario().getPassword().equals(pacienteForm.getUsuario().getPassword()) && paciente.getUsuario().getPasswordConfirm().equals(pacienteForm.getUsuario().getPasswordConfirm())) {
				paciente.getUbicacion().setLatitud(pacienteForm.getUbicacion().getLatitud());
				paciente.getUbicacion().setNombre(pacienteForm.getUbicacion().getNombre());
				paciente.getUbicacion().setLongitud(pacienteForm.getUbicacion().getLongitud());
				paciente.getUbicacion().getComuna().setId(pacienteForm.getUbicacion().getComuna().getId());
				paciente.setFono(pacienteForm.getFono());
				if(!archivo.isEmpty()) {
					String file = fileManagerUtil.subirArchivo(archivo, Seccion.PACIENTE, pacienteForm.getRut());
					paciente.setFoto(file);
				}
				pacienteService.save(paciente);
				model.addAttribute("mensaje", "Sus datos fueron guardados con �xito");
			}else {
				model.addAttribute("mensajeError", "Contrase�a Incorrecta");
			}
		}
		return "paciente/paciente";
	}

	@RequestMapping(value = "/paciente/misatenciones", method = RequestMethod.GET)
	public String misatenciones(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		List<Agenda> agendas = agendaService.findByPaciente(paciente);
		List<Atencion> atenciones = new ArrayList<>();
		Atencion atencion = null;
		for (Agenda agenda : agendas) {
			atencion = atencionService.findByAgenda(agenda);
			if (atencion != null)
				atenciones.add(atencion);
		}
		model.addAttribute("atenciones", atenciones);
		model.addAttribute("paciente", paciente);
		return "paciente/atenciones";
	}

	@RequestMapping(value = "/paciente/detalleAtencion", method = RequestMethod.GET)
	public String detalleAtencion(Model model, @RequestParam("id") int id) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		Atencion atencion = atencionService.findById(id);
		model.addAttribute("atencion", atencion);
		model.addAttribute("paciente", paciente);
		return "paciente/detalleAtencion";
	}

	@RequestMapping(value = "/paciente/califica", method = RequestMethod.GET)
	public String calificar(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		model.addAttribute("paciente", paciente);
		return "paciente/paciente";
	}

	@RequestMapping(value = "/paciente/quizPatologia", method = RequestMethod.GET)
	public String solicitud(Model model) {
		List<Patologia> patologias = patologiaService.findAll();
		model.addAttribute("patologias", patologias);
		return "paciente/quiz";
	}

	@RequestMapping(value = "/paciente/selectPodologo", method = RequestMethod.GET)
	public String seleccionaPatologia(Model model, @RequestParam("id") int id) {
		Patologia patologia = patologiaService.findById(id);
		model.addAttribute("patologia", patologia);
		model.addAttribute("precioPorKilometro", Constantes.VALOR_POR_KILOMETRO);
		model.addAttribute("solicitudForm", new Solicitudatencion());
		return "paciente/seleccionaPodologo";
	}

	@RequestMapping(value = "/paciente/guardarAgenda", method = RequestMethod.POST)
	public String guardarAgenda(Model model, @ModelAttribute("solicitudForm") Solicitudatencion solicitudAtencion,
			@RequestParam("fotoPiePaciente") MultipartFile fotoPiePaciente,
			@RequestParam("kilometros") String kilometros) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		Patologia patologia = patologiaService.findById(solicitudAtencion.getPatologia().getId());
		Podologo podologo = podologoService.find(solicitudAtencion.getPodologo().getRut());
		Horario horario = horarioService.findById(solicitudAtencion.getHorario().getId());
		Parametro parametroPendiente = parametroService.findOne(Parametros.ESTADO_SOLICITUD_PENDIENTE);// pendiente
																										// (estado
																										// Solicitud)
		FileManagerUtil fileManagerUtil =new FileManagerUtil();
		Parametro parametroTomado = parametroService.findOne(Parametros.ESTADO_HORARIO_TOMADO);// tomado
		String fotoPie = fileManagerUtil.subirArchivo(fotoPiePaciente, Seccion.SOLICITUDES_ATENCION, paciente.getRut());
		if (solicitudAtencionService.findByHorario(horario) == null) {
			Double cantidad_Kilometros = Double.parseDouble(kilometros);
			// saca presupuesto
			Presupuesto presupuesto = new Presupuesto();
			presupuesto.setUbicacionPartida(podologo.getUbicacion());
			presupuesto.setUbicacionLlegada(paciente.getUbicacion());
			presupuesto.setCantidadKM(cantidad_Kilometros);
			presupuesto.setTarifaKM(Constantes.VALOR_POR_KILOMETRO);
			presupuesto.setViajePodologo((int) (presupuesto.getTarifaKM() * presupuesto.getCantidadKM()));
			presupuesto.setTotal(presupuesto.getViajePodologo() + patologia.getCosto());

			solicitudAtencion.setPaciente(paciente);
			solicitudAtencion.setPatologia(patologia);
			solicitudAtencion.setPodologo(podologo);
			solicitudAtencion.setHorario(horario);
			solicitudAtencion.setParamEstadoSolicitudAtencion(parametroPendiente);
			solicitudAtencion.setFechaSolicitud(DateUtil.getFechaHoyString());
			solicitudAtencion.setFechaSolicitud(DateUtil.getFechaHoyString());
			solicitudAtencion.setPresupuesto(presupuesto);
			solicitudAtencion.setFotoPiePath(fotoPie);
			solicitudAtencionService.save(solicitudAtencion);

			horario.setParamEstadoHorario(parametroTomado);

			horarioService.save(horario);
			if (podologo.getParamSexo().getId() == Parametros.ESTADO_SEXO_M)
				model.addAttribute("mensaje",
						"Solicitud de Atenci�n ingresada, el Pod�logo responder� a la brevedad... ");
			else
				model.addAttribute("mensaje",
						"Solicitud de Atenci�n ingresada, la Pod�loga responder� a la brevedad... ");
		}
		model.addAttribute("paciente", paciente);
		return "paciente/paciente";
	}
}
