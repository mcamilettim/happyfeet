package cl.camiletti.happyFeetWeb.web;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.PatologiaService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.service.SecurityService;
import cl.camiletti.happyFeetWeb.service.UbicacionService;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.DateUtil;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;
import cl.camiletti.happyFeetWeb.util.Mail;
import cl.camiletti.happyFeetWeb.util.Seccion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
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

@Controller
@SessionAttributes("sessionUser paciente")
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

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String registration(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario usuario = usuarioService.findByEmail(user.getUsername());
		model.addAttribute("user", usuario);

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
				model.addAttribute("mensaje", "Este email se encuentra registrado. Inicie sesión.");
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

	@RequestMapping(value = "/admin/modificardatos", method = RequestMethod.POST)
	public String modificarpost(@ModelAttribute("pacienteForm") Paciente pacienteForm,
			@RequestParam("archivo") MultipartFile archivo, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		} else {
			Mail mail = new Mail(env);
			if (archivo != null) {
				String file = fileManagerUtil.subirArchivo(archivo,Seccion.ADMIN,pacienteForm.getRut());
				List<String> archivos = new ArrayList<String>();
				archivos.add(file);
				mail.sendEmailSolicitudPaciente(env.getProperty("emails.admins"), archivos, null);
			}

			if (usuarioService.findByEmail(pacienteForm.getEmail()) != null) {
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

				mail.sendEmailBienvenidoPaciente(pacienteForm.getEmail(),
						pacienteForm.getNombres() + pacienteForm.getApellidos());
				model.addAttribute("mensaje", "Sus datos fueron guardados con éxito");
			}
		}
		return "paciente/modificardatos";
	}

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
	public String modificarPacientePost(@ModelAttribute("pacienteForm") Paciente pacienteForm, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {

		} else {
			Usuario user = usuarioService.findById(pacienteForm.getUsuario().getId());
			user.setEmail(pacienteForm.getEmail());
			user.setPassword(pacienteForm.getUsuario().getPassword());
			user.setPasswordConfirm(pacienteForm.getUsuario().getPasswordConfirm());
			pacienteForm.setUsuario(user);
			pacienteForm.setParamSexo(parametroService.findOne(pacienteForm.getParamSexo().getId()));
			pacienteService.save(pacienteForm);
			model.addAttribute("mensaje", "Sus datos fueron guardados con éxito");
		}
		model.addAttribute("pacientes", pacienteService.findAll());
		return "admin/pacientes";
	}

	@RequestMapping(value = "/admin/verPacientes", method = RequestMethod.GET)
	public String verPacientes(Model model) {

		model.addAttribute("pacientes", pacienteService.findAll());

		return "admin/pacientes";
	}

	@RequestMapping(value = "/admin/verPodologos", method = RequestMethod.GET)
	public String verPodologos(Model model) {

		model.addAttribute("podologos", podologoService.findAll());

		return "admin/podologos";
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
	public String modificarPodologoPost(@ModelAttribute("podologoForm") Podologo podologoForm, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {

		} else {
			Usuario user = usuarioService.findById(podologoForm.getUsuario().getId());
			user.setEmail(podologoForm.getEmail());
			user.setPassword(podologoForm.getUsuario().getPassword());
			user.setPasswordConfirm(podologoForm.getUsuario().getPasswordConfirm());
			podologoForm.setUsuario(user);
			podologoForm.setParamSexo(parametroService.findOne(podologoForm.getParamSexo().getId()));
			podologoService.save(podologoForm);
			model.addAttribute("mensaje", "Sus datos fueron guardados con éxito");
		}
		model.addAttribute("podologos", podologoService.findAll());
		return "admin/podologos";
	}
	
    @RequestMapping(value = "/admin/listarPatologias", method = RequestMethod.GET)
    public String listarPatologias(Model model) {
    	
    	List<Patologia> patologias = patologiaService.findAll();
    	model.addAttribute("patologias",patologias);
    	model.addAttribute("patologiaForm", new Patologia());
    	
    	return "admin/listarPatologias";
    }
    
    @RequestMapping(value = "/admin/buscarPatologias", method = RequestMethod.POST)
    public String buscarPatologias(Model model, @RequestParam("textBuscar") String textBuscar){
    	model.addAttribute("patologias", patologiaService.findByNombreIsLike(textBuscar));
    	model.addAttribute("patologiaForm", new Patologia());
    	return "admin/listarPatologias"; 
    }    
    
    @RequestMapping(value = "/admin/ingresarPatologia", method = RequestMethod.POST)
    public String ingresarPatologia(Model model, @ModelAttribute("patologiaForm") Patologia patologiaForm, @RequestParam("fotoFile") MultipartFile foto) {
    	
    	patologiaForm.setFoto(patologiaForm.getNombre()+"."+FilenameUtils.getExtension(foto.getOriginalFilename()));
    /*	try {
			foto.transferTo(new File("c:\\"+patologiaForm.getFoto()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	//fileManagerUtil.subirArchivoPaciente(foto,"c:/");
    	
    	patologiaService.save(patologiaForm);
    	model.addAttribute("patologias", patologiaService.findAll());
    	return "admin/listarPatologias";
    }
    
    @RequestMapping(value = "/admin/eliminarPatologia", method = RequestMethod.GET)
    public String eliminarPatologia(Model model, @RequestParam("idPatologia") int idPatologia) {
    	Patologia patologia=new Patologia();
    	patologia.setId(idPatologia);
    	patologiaService.deleteById(patologia); 
    	model.addAttribute("mensaje", "Patologia eliminada con éxito");
    	List<Patologia> patologias = patologiaService.findAll();
    	model.addAttribute("patologias",patologias);  
    	model.addAttribute("patologiaForm", new Patologia());
    	return "admin/listarPatologias";
    }
    
    @RequestMapping(value = "/admin/modificarPatologia", method = RequestMethod.GET)
    public String modificarPatologiaGet(Model model, @RequestParam("idPatologia") int idPatologia) {
    	Patologia patologiaForm=patologiaService.findById(idPatologia);
    	model.addAttribute("patologiaForm", patologiaForm);
    	return "admin/modificarPatologia";
    } 
    
    @RequestMapping(value = "/admin/modificarPatologia", method = RequestMethod.POST)
    public String modificarPatologiaPost(Model model, @ModelAttribute("patologiaForm") Patologia patologiaForm, @RequestParam("fotoFile") MultipartFile foto) {
    	    	
    	patologiaForm.setFoto(patologiaForm.getNombre()+"."+FilenameUtils.getExtension(foto.getOriginalFilename()));
    /*	try {
			foto.transferTo(new File("c:\\"+patologiaForm.getFoto()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	//fileManagerUtil.subirArchivoPaciente(foto,"c:/");
    	patologiaService.save(patologiaForm);
    	model.addAttribute("mensaje", "Patologia modificada con éxito");
    	model.addAttribute("patologias", patologiaService.findAll());
    	return "admin/listarPatologias";

    }   
}
