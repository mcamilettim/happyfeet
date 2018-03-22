package cl.camiletti.happyFeetWeb.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.PodologoService;

@RestController
@RequestMapping("/servicesPodologo")
public class PodologoControllerRest {
	
	@Autowired
	ComunaService comunaService;
	
	@RequestMapping(value = "/podologo/getPodologosPorComuna", method = RequestMethod.GET, produces = "application/json")
	public List<Podologo> cargarPacientes(Model model, @RequestParam("idComuna")int idComuna) {
		Comuna comuna=comunaService.findById(idComuna);
		List<Ubicacion> ubicaciones=comuna.getUbicacions();
		List<Podologo> podologos=new ArrayList();
		
		for (Ubicacion ubicacion : ubicaciones) {
			for (Podologo podologo : ubicacion.getPodologos()) {
				Podologo podoAux=new Podologo();
				podoAux.setNombres(podologo.getNombres());
				podoAux.setRut(podologo.getRut());
				Ubicacion ubicacionAux=new Ubicacion();
				ubicacionAux.setLatitud(ubicacion.getLatitud());
				ubicacionAux.setId(ubicacion.getId());				
				ubicacionAux.setLongitud(ubicacion.getLongitud());
				podoAux.setUbicacion(ubicacionAux);
				podologos.add(podoAux);
			}
		}
		
		return podologos;
	}
}
