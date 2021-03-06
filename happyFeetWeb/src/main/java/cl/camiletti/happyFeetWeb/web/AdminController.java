package cl.camiletti.happyFeetWeb.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
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

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Cuestionariopodologo;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitud;
import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.CuestionarioService;
import cl.camiletti.happyFeetWeb.service.CuestionariopacienteService;
import cl.camiletti.happyFeetWeb.service.CuestionariopodologoService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.PatologiaService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.service.SecurityService;
import cl.camiletti.happyFeetWeb.service.SolicitudService;
import cl.camiletti.happyFeetWeb.service.UbicacionService;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.Constantes;
import cl.camiletti.happyFeetWeb.util.DateUtil;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;
import cl.camiletti.happyFeetWeb.util.Mail;
import cl.camiletti.happyFeetWeb.util.Parametros;

@Controller
@SessionAttributes(value = { "admin", "solicitud" })
public class AdminController {
	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ComunaService comunaService;

	@Autowired
	private UbicacionService ubicacionService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DateUtil dateUtil;

	@Autowired
	private Environment env;

	@Autowired
	FileManagerUtil fileManagerUtil;

	@Autowired
	private DateUtil utilDate;

	@Autowired
	private PodologoService podologoService;

	@Autowired
	private PatologiaService patologiaService;

	@Autowired
	private SolicitudService solicitudService;
	@Autowired
	private CuestionariopodologoService cuestionariopodologoService;

	@Autowired
	private CuestionariopacienteService cuestionariopacienteService;
	@Autowired
	private CuestionarioService cuestionarioService;

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String registration(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario usuario = usuarioService.findByEmail(user.getUsername());
		model.addAttribute("admin", usuario);
		return "admin/admin";
	}

	@RequestMapping(value = "/admin/lala", method = RequestMethod.POST)
	public String register(@ModelAttribute("pacienteForm") Paciente pacienteForm, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {

		} else {
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
				usuarioService.save(pacienteForm.getUsuario());
				pacienteService.save(pacienteForm);
				Mail mail = new Mail(env);
				mail.sendEmailBienvenidoPaciente(pacienteForm.getEmail(),
						pacienteForm.getNombres() + pacienteForm.getApellidos());
				model.addAttribute("mensaje", "Paciente registrado con exito.");
			} else {
				model.addAttribute("mensaje", "Este email se encuentra registrado. Inicie sesi�n.");
			}
			return "login";
		}
		return "paciente/registrar";
	}

	// @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	// public String index(Model model) {
	// User user =
	// (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	// Paciente paciente=pacienteService.findByEmail(user.getUsername());
	// model.addAttribute("paciente", paciente);
	// return "paciente/paciente";
	// }

	@RequestMapping(value = "/admin/buscarPacientes", method = RequestMethod.POST)
	public String buscarPaciente(Model model, @RequestParam("selectBuscar") String criterioBusqueda,
			@RequestParam("textBuscar") String textBuscar) {

		ArrayList<Paciente> pacientes = new ArrayList();
		String mensaje = "";
		if (criterioBusqueda.equals("Nombre")) {
			pacientes = (ArrayList<Paciente>) pacienteService.findByNombre(textBuscar);
		} else {
			if (criterioBusqueda.equals("Rut")) {
				pacientes.add(pacienteService.find(textBuscar));
				pacientes = (ArrayList<Paciente>) pacientes.stream().distinct().collect(Collectors.toList());
			}
		}
		if (pacientes.size() == 0) {
			mensaje = "No se encontraron resultados";
		}

		model.addAttribute("pacientes", pacientes);

		return "admin/pacientes";
	}

	@RequestMapping(value = "/admin/modificarDatosPaciente", method = RequestMethod.GET)
	public String modificarPacienteGet(Model model, @RequestParam String rut) {
		Paciente paciente = pacienteService.find(rut);
		model.addAttribute("rutPaciente", rut);
		model.addAttribute("pacienteForm", paciente);
		model.addAttribute("ubicacion", paciente.getUbicacion().getNombre());
		model.addAttribute("comuna", paciente.getUbicacion().getComuna().getNombre());
		model.addAttribute("paramSexo", paciente.getParamSexo());
		model.addAttribute("usuario", paciente.getUsuario());
		model.addAttribute("sexos", parametroService.findByNumero(44));
		model.addAttribute("comunas", comunaService.findAll());

		return "admin/modificarPaciente";
	}

	@RequestMapping(value = "/admin/modificarDatosPaciente", method = RequestMethod.POST)
	public String modificarPacientePost(@ModelAttribute("pacienteForm") Paciente pacienteForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

		} else {
			Usuario user = usuarioService.findById(pacienteForm.getUsuario().getId());
			user.setEmail(pacienteForm.getEmail());
			user.setPassword(pacienteForm.getUsuario().getPassword());
			user.setPasswordConfirm(pacienteForm.getUsuario().getPasswordConfirm());
			pacienteForm.setUsuario(user);
			pacienteForm.setParamSexo(parametroService.findOne(pacienteForm.getParamSexo().getId()));
			pacienteService.save(pacienteForm);
			model.addAttribute("mensaje", "Sus datos fueron guardados con �xito");
		}
		model.addAttribute("pacientes", pacienteService.findAll());
		return "admin/pacientes";
	}

	@RequestMapping(value = "/admin/pacientes", method = RequestMethod.GET)
	public String verPacientes(Model model) {

		model.addAttribute("pacientes", pacienteService.findAll());

		return "admin/pacientes";
	}

	@RequestMapping(value = "/admin/podologos", method = RequestMethod.GET)
	public String verPodologos(Model model) {

		model.addAttribute("podologos", podologoService.findAll());

		return "admin/podologos";
	}

	@RequestMapping(value = "/admin/solicitudes", method = RequestMethod.GET)
	public String solicitudes(Model model) {
		List<Parametro> parametros = new ArrayList<Parametro>();
		Parametro parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_PENDIENTE);
		parametros.add(parametro);
		model.addAttribute("solicitudesPendientes", solicitudService.findByParamEstadoSolicitudIn(parametros));
		model.addAttribute("solicitudesRespondidas", solicitudService.findByParamEstadoSolicitudNotIn(parametros));
		return "admin/solicitudes";
	}

	@RequestMapping(value = "/admin/modificarDatosPodologo", method = RequestMethod.GET)
	public String modificarPodologoGet(Model model, @RequestParam String rut) {
		Podologo podologo = podologoService.find(rut);
		model.addAttribute("rutPaciente", rut);
		model.addAttribute("podologoForm", podologo);
		model.addAttribute("ubicacion", podologo.getUbicacion().getNombre());
		model.addAttribute("comuna", podologo.getUbicacion().getComuna().getNombre());
		model.addAttribute("paramSexo", podologo.getParamSexo());
		model.addAttribute("usuario", podologo.getUsuario());
		model.addAttribute("sexos", parametroService.findByNumero(44));
		model.addAttribute("comunas", comunaService.findAll());

		return "admin/modificarPodologo";
	}

	@RequestMapping(value = "/admin/modificarDatosPodologo", method = RequestMethod.POST)
	public String modificarPodologoPost(@ModelAttribute("podologoForm") Podologo podologoForm,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

		} else {
			Usuario user = usuarioService.findById(podologoForm.getUsuario().getId());
			user.setEmail(podologoForm.getEmail());
			user.setPassword(podologoForm.getUsuario().getPassword());
			user.setPasswordConfirm(podologoForm.getUsuario().getPasswordConfirm());
			podologoForm.setUsuario(user);
			podologoForm.setParamSexo(parametroService.findOne(podologoForm.getParamSexo().getId()));
			podologoService.save(podologoForm);
			model.addAttribute("mensaje", "Sus datos fueron guardados con �xito");
		}
		model.addAttribute("podologos", podologoService.findAll());
		return "admin/podologos";
	}

	@RequestMapping(value = "/admin/listarPatologias", method = RequestMethod.GET)
	public String listarPatologias(Model model) {

		List<Patologia> patologias = patologiaService.findAll();
		model.addAttribute("patologias", patologias);
		model.addAttribute("patologiaForm", new Patologia());

		return "admin/listarPatologias";
	}

	@RequestMapping(value = "/admin/buscarPatologias", method = RequestMethod.POST)
	public String buscarPatologias(Model model, @RequestParam("textBuscar") String textBuscar) {
		model.addAttribute("patologias", patologiaService.findByNombreIsLike(textBuscar));
		model.addAttribute("patologiaForm", new Patologia());
		return "admin/listarPatologias";
	}

	@RequestMapping(value = "/admin/ingresarPatologia", method = RequestMethod.POST)
	public String ingresarPatologia(Model model, @ModelAttribute("patologiaForm") Patologia patologiaForm,
			@RequestParam("fotoFile") MultipartFile foto) {

		patologiaForm.setFoto(patologiaForm.getNombre() + "." + FilenameUtils.getExtension(foto.getOriginalFilename()));
		/*
		 * try { foto.transferTo(new File("c:\\"+patologiaForm.getFoto())); } catch
		 * (IllegalStateException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		// fileManagerUtil.subirArchivoPaciente(foto,"c:/");

		patologiaService.save(patologiaForm);
		model.addAttribute("patologias", patologiaService.findAll());
		return "admin/listarPatologias";
	}

	@RequestMapping(value = "/admin/eliminarPatologia", method = RequestMethod.GET)
	public String eliminarPatologia(Model model, @RequestParam("idPatologia") int idPatologia) {
		Patologia patologia = new Patologia();
		patologia.setId(idPatologia);
		patologiaService.deleteById(patologia);
		model.addAttribute("mensaje", "Patologia eliminada con �xito");
		List<Patologia> patologias = patologiaService.findAll();
		model.addAttribute("patologias", patologias);
		model.addAttribute("patologiaForm", new Patologia());
		return "admin/listarPatologias";
	}

	@RequestMapping(value = "/admin/modificarPatologia", method = RequestMethod.GET)
	public String modificarPatologiaGet(Model model, @RequestParam("idPatologia") int idPatologia) {
		Patologia patologiaForm = patologiaService.findById(idPatologia);
		model.addAttribute("patologiaForm", patologiaForm);
		return "admin/modificarPatologia";
	}

	@RequestMapping(value = "/admin/modificarPatologia", method = RequestMethod.POST)
	public String modificarPatologiaPost(Model model, @ModelAttribute("patologiaForm") Patologia patologiaForm,
			@RequestParam("fotoFile") MultipartFile foto) {

		patologiaForm.setFoto(patologiaForm.getNombre() + "." + FilenameUtils.getExtension(foto.getOriginalFilename()));
		/*
		 * try { foto.transferTo(new File("c:\\"+patologiaForm.getFoto())); } catch
		 * (IllegalStateException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		// fileManagerUtil.subirArchivoPaciente(foto,"c:/");
		patologiaService.save(patologiaForm);
		model.addAttribute("mensaje", "Patologia modificada con �xito");
		model.addAttribute("patologias", patologiaService.findAll());
		return "admin/listarPatologias";

	}

	@RequestMapping(value = "/admin/cuestionarios", method = RequestMethod.GET)
	public String cuestionarios(Model model) {
		List<Cuestionario> cuestionariosPaciente = cuestionarioService.findByTipo("paciente");
		List<Cuestionario> cuestionariosPodologo = cuestionarioService.findByTipo("podologo");
		model.addAttribute("cuestionariosPaciente", cuestionariosPaciente);
		model.addAttribute("cuestionariosPodologo", cuestionariosPodologo);

		return "admin/cuestionarios";

	}

	@RequestMapping(value = "/admin/nuevoCuestionario", method = RequestMethod.GET)
	public String nuevoCuestionario(Model model) {
		model.addAttribute("cuestionario", new Cuestionario());
		return "admin/nuevoCuestionario";
	}

	@RequestMapping(value = "/admin/verCuestionario", method = RequestMethod.GET)
	public String verCuestionario(Model model, @RequestParam("id") int id) {
		Cuestionario cuestionario = cuestionarioService.findById(id);
		model.addAttribute("cuestionario", cuestionario);
		return "admin/verCuestionario";
	}

	@RequestMapping(value = "/admin/verSolicitud", method = RequestMethod.GET)
	public String verSolicitud(Model model, @RequestParam("id") int id) {
		Solicitud solicitud = solicitudService.findById(id);
		model.addAttribute("solicitud", solicitud);
		model.addAttribute("solicitudForm", solicitud);
		return "admin/verSolicitud";
	}

	@RequestMapping(value = "/admin/responderSolicitud", method = RequestMethod.POST)
	public String responderSolicitud(Model model, @RequestParam("respuesta") String respuesta,
			@ModelAttribute("solicitud") Solicitud solicitud,
			@ModelAttribute("solicitudForm") Solicitud solicitudForm) {
		Parametro parametro = null;
		solicitud.setRazon(solicitudForm.getRazon());
		if (respuesta.equalsIgnoreCase(Constantes.RESPUESTA_SOLICITUD_ATENCION_SI)) {
			parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_ACEPTADA);
			solicitud.setParamEstadoSolicitud(parametro);

			Podologo podologo = new Podologo();
			podologo.setNombres(solicitud.getNombres());
			podologo.setApellidos(solicitud.getApellidos());
			podologo.setFono(solicitud.getFono());
			podologo.setEmail(solicitud.getEmail());
			podologo.setParamSexo(solicitud.getParamSexo());
			podologo.setUbicacion(solicitud.getUbicacion());
			podologo.setRut(solicitud.getRutPodologo());

			parametro = parametroService.findOne(Parametros.ESTADO_TIPO_USUARIO_PODOLOGO);
			Usuario usuario = new Usuario();
			usuario.setEmail(solicitud.getEmail());
			usuario.setPassword("123");
			usuario.setPasswordConfirm("123");
			usuario.setParamTipoUsuario(parametro);
			usuarioService.save(usuario);
			podologo.setUsuario(usuario);
			parametro = parametroService.findOne(Parametros.ESTADO_PODOLOGO_ACTIVO);
			podologo.setParamEstadoPodologo(parametro);
			podologoService.save(podologo);

			List<Cuestionario> cuestionariosHabilitados = cuestionarioService.findByTipoAndParamEstadoCuestionario(
					Parametros.ESTADO_TIPO_CUESTIONARIO_PODOLOGO,
					parametroService.findOne(Parametros.ESTADO_DESCUENTO_DISPONIBLE));
			Cuestionariopodologo cuestionarioPodologo = null;
			Parametro disponible = parametroService.findOne(Parametros.ESTADO_DESCUENTO_DISPONIBLE);
			Parametro pendiente = parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_PENDIENTE);
			for (Cuestionario cuestionario : cuestionariosHabilitados) {
				cuestionarioPodologo = new Cuestionariopodologo();
				cuestionarioPodologo.setCuestionario(cuestionario);
				cuestionarioPodologo.setParamEstadoCuestionario(pendiente);
				cuestionarioPodologo.setParamEstadoDescuento(disponible);
				cuestionarioPodologo.setPodologo(podologo);
				cuestionariopodologoService.save(cuestionarioPodologo);
			}

			model.addAttribute("mensaje", "Solicitud Aceptada con �xito");
		} else {
			parametro = parametroService.findOne(Parametros.ESTADO_SOLICITUD_RECHAZADA);
			solicitud.setParamEstadoSolicitud(parametro);
			model.addAttribute("mensaje", "Solicitud Rechazada con �xito");
		}
		solicitudService.save(solicitud);

		model.addAttribute("solicitud", solicitud);
		return "admin/admin";
	}
}
