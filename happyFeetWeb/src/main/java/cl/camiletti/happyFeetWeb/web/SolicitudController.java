package cl.camiletti.happyFeetWeb.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Solicitud;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.SolicitudService;
import cl.camiletti.happyFeetWeb.service.UbicacionService;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;
import cl.camiletti.happyFeetWeb.util.Mail;
import cl.camiletti.happyFeetWeb.util.Seccion;

@Controller
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    
    @Autowired
    private ParametroService parametroService;

    @Autowired    
    private ComunaService comunaService;
    
    @Autowired
    private UbicacionService ubicacionService;
    
   
    @Autowired
    FileManagerUtil fileManagerUtil;
    
    @Autowired
	private Environment env;
    

    @RequestMapping(value = "/solicitud", method = RequestMethod.GET)
    public String solicitud(Model model) {
        model.addAttribute("solicitudForm", new Solicitud());        
        model.addAttribute("comuna", new Comuna());
        model.addAttribute("paramSexo", new Parametro());     
        model.addAttribute("sexos", parametroService.findByNumero(44));
        model.addAttribute("comunas", comunaService.findAll());
        
        return "podologo/solicitud";
    }

    @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
    public String solicitud(@ModelAttribute("solicitudForm") Solicitud solicitud, BindingResult bindingResult, Model model, @RequestParam("carnet") MultipartFile carnet, @RequestParam("titulo") MultipartFile titulo) throws IOException {
    	
    	
    	String fotoCarnet = fileManagerUtil.subirArchivo(carnet, Seccion.SOLICITUDES,solicitud.getRutPodologo());
    	String fotoTitulo = fileManagerUtil.subirArchivo(titulo,Seccion.SOLICITUDES,solicitud.getRutPodologo());
    	
    	solicitud.setCarnet(fotoCarnet);
    	solicitud.setTitulo(fotoCarnet);
    	solicitud.setParamEstadoSolicitud(new Parametro(12));
    	ubicacionService.save(solicitud.getUbicacion());
    	solicitud.setUbicacion(ubicacionService.findByNombre(solicitud.getUbicacion().getNombre()));
    	solicitudService.save(solicitud);   
    	
    	Mail mail = new Mail(env);
    	List<String> archivos = new ArrayList<String>();
    	archivos.add(fotoCarnet);
    	archivos.add(fotoTitulo);
    	mail.sendEmailSolicitudPodologo(solicitud.getEmail(), solicitud.getNombres() + solicitud.getApellidos(), "", "", null, solicitud);
    	mail.sendEmailSolicitudPodologoAdmin(env.getProperty("emails.admins"), solicitud.getNombres(), "", "", archivos, solicitud);
    	model.addAttribute("exito", "Solicitud enviada con éxito.");
    	return "solicitud";
    }

   
}
