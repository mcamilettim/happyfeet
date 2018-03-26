package cl.camiletti.happyFeetWeb.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.custom.PodologoCustom;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.EvaluacionService;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;

@RestController
@RequestMapping("/servicesPodologo")
public class PodologoControllerRest {
	
	@Autowired
	ComunaService comunaService;
	@Autowired
	EvaluacionService evaluacionService;
	
	@RequestMapping(value = "/podologo/getPodologosPorComuna", method = RequestMethod.GET, produces = "application/json")
	public List<PodologoCustom> cargarPacientes(Model model, @RequestParam("idComuna")int idComuna) {
		Comuna comuna=comunaService.findById(idComuna);
		List<Ubicacion> ubicaciones=comuna.getUbicacions();
		List<PodologoCustom> podologos=new ArrayList<PodologoCustom>();
		
		for (Ubicacion ubicacion : ubicaciones) {
			for (Podologo podologo : ubicacion.getPodologos())  {
				PodologoCustom podoAux=new PodologoCustom();
				try {
					podoAux.setFoto(FileManagerUtil.encodeFileToBase64Binary(FileManagerUtil.ROOT_PATH+File.separator+podologo.getFoto()));
				} catch (IOException e) {
					podoAux.setFoto(null);
				}
				podoAux.setNombres(podologo.getNombres());
				podoAux.setApellidos(podologo.getApellidos());
				podoAux.setRut(podologo.getRut());
				Ubicacion ubicacionAux=new Ubicacion();
				ubicacionAux.setLatitud(ubicacion.getLatitud());
				ubicacionAux.setId(ubicacion.getId());				
				ubicacionAux.setLongitud(ubicacion.getLongitud());
				
				podoAux.setUbicacion(ubicacionAux);
				podoAux.setEvaluacion(getEvaluacion(podoAux.getRut()));
				podologos.add(podoAux);
			}
		}
		
		return podologos;
	}
	
	 
	public Double getEvaluacion(String rut) {
		List<Evaluacion> evaluaciones=evaluacionService.findByRutReceptor(rut);
		double valoracionTotal=0;
		for (Evaluacion evaluacion : evaluaciones) {
			valoracionTotal=valoracionTotal+evaluacion.getValor();
		}
		if(evaluaciones!=null && evaluaciones.size()>0) {
			return valoracionTotal/evaluaciones.size();
		}else {
			return (double) 0;
		}
	}
}
