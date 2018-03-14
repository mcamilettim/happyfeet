package cl.camiletti.happyFeetWeb.web;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.SecurityService;
import cl.camiletti.happyFeetWeb.service.UbicacionService;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.DateUtil;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;
import cl.camiletti.happyFeetWeb.util.Mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
@SessionAttributes("sessionUser")
public class PacienteController {
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
    public String registration(@ModelAttribute("pacienteForm") Paciente pacienteForm, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
    		
    	} else {
	    	if(usuarioService.findByEmail(pacienteForm.getEmail()) == null) {
	    		if(ubicacionService.findByNombre(pacienteForm.getUbicacion().getNombre()) == null){
	    			ubicacionService.save(pacienteForm.getUbicacion());
	    		}
	        	Usuario user=new Usuario();
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
	        	mail.sendEmailBienvenidoPaciente(pacienteForm.getEmail(), pacienteForm.getNombres() + " "+ pacienteForm.getApellidos());
	        	model.addAttribute("mensaje","Paciente registrado con exito.");
	    	} else {
	    		model.addAttribute("mensaje","Este email se encuentra registrado. Inicie sesión.");
	    	}
	    	return "login";
    	}
    	return "paciente/registrar";
    }

    @RequestMapping(value = "/paciente/index", method = RequestMethod.GET)
    public String redirect(Model model) {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Paciente paciente=pacienteService.findByEmail(user.getUsername());
    	model.addAttribute("paciente", paciente);
    	return "paciente/paciente";
    }  
    
    @RequestMapping(value = "/paciente/modificardatos", method = RequestMethod.GET)
    public String modificardatos(Model model) {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Paciente paciente=pacienteService.findByEmail(user.getUsername());
    	
        model.addAttribute("pacienteForm", paciente);
        model.addAttribute("ubicacion", paciente.getUbicacion().getNombre());
        model.addAttribute("comuna", paciente.getUbicacion().getComuna().getNombre());
        model.addAttribute("paramSexo", paciente.getParamSexo());
        model.addAttribute("usuario", paciente.getUsuario());        
        model.addAttribute("sexos", parametroService.findByNumero(44));
        model.addAttribute("comunas", comunaService.findAll());
    	
    	
    	return "paciente/modificar";
    }
    
    @RequestMapping(value = "/paciente/modificardatos", method = RequestMethod.POST)
    public String modificarpost(@ModelAttribute("pacienteForm") Paciente pacienteForm, @RequestParam("archivo") MultipartFile archivo, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
    		
    	} else {
    		Mail mail = new Mail(env);

    		Usuario user = usuarioService.findByEmail(pacienteForm.getEmail());
    		
	    	if(user != null) {
	    		if(ubicacionService.findByNombre(pacienteForm.getUbicacion().getNombre()) == null){
	    			ubicacionService.save(pacienteForm.getUbicacion());
	    		}
	        	user.setEmail(pacienteForm.getEmail());
	        	user.setPassword(pacienteForm.getUsuario().getPassword());
	        	user.setPasswordConfirm(pacienteForm.getUsuario().getPasswordConfirm());
	        	usuarioService.save(user);     
	        	
	        	Paciente paciente = pacienteService.findByEmail(pacienteForm.getEmail());
	        	paciente.setUsuario(usuarioService.findByEmail(pacienteForm.getEmail()));
	        	paciente.setUbicacion(ubicacionService.findByNombre(pacienteForm.getUbicacion().getNombre()));    	
	        	paciente.getUsuario().setParamTipoUsuario(parametroService.findOne(17)); 	
	        	paciente.setEdad(dateUtil.getAge(pacienteForm.getFechaNacimiento()));
	        	pacienteService.save(paciente);
	        	
	        	//mail.sendEmailBienvenidoPaciente(pacienteForm.getEmail(), pacienteForm.getNombres() + pacienteForm.getApellidos());
	        	model.addAttribute("mensaje","Sus datos fueron guardados con éxito");
	        	
	    		if(!archivo.isEmpty()) {
	    			File file = fileManagerUtil.subirArchivo(archivo);
	    			List<String> archivos = new ArrayList<String>();
	    			archivos.add(file.getName());
	    			mail.sendEmailSolicitudPaciente(env.getProperty("emails.admins"), archivos, paciente);
	    		}
	    	} 
    	}
        model.addAttribute("sexos", parametroService.findByNumero(44));
        model.addAttribute("comunas", comunaService.findAll());
    	return "paciente/modificar";
    }
    
    @RequestMapping(value = "/paciente/misatenciones", method = RequestMethod.GET)
    public String misatenciones(Model model) {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Paciente paciente=pacienteService.findByEmail(user.getUsername());
    	model.addAttribute("paciente", paciente);
    	return "paciente/paciente";
    }  
    
    @RequestMapping(value = "/paciente/califica", method = RequestMethod.GET)
    public String calificar(Model model) {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Paciente paciente=pacienteService.findByEmail(user.getUsername());
    	model.addAttribute("paciente", paciente);
    	return "paciente/paciente";
    }
    
    @RequestMapping(value = "/paciente/solicitud", method = RequestMethod.GET)
    public String solicitud(Model model) {
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Paciente paciente=pacienteService.findByEmail(user.getUsername());
    	model.addAttribute("paciente", paciente);
    	return "paciente/paciente";
    }
}
