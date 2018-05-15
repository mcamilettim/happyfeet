package cl.camiletti.happyFeetWeb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.custom.CuestionarioCustom;
import cl.camiletti.happyFeetWeb.service.CuestionarioService;
import cl.camiletti.happyFeetWeb.service.CuestionariopacienteService;

@RestController
@RequestMapping("/servicesCuestionario")
public class CuestionarioControllerRest {
	@Autowired
	private CuestionarioService cuestionarioService;
	@Autowired
	private CuestionariopacienteService cuestionariopacienteService;
	@Autowired
	private CuestionariopacienteService cuestionariopodologoService;

	@RequestMapping(value = "/getCuestionario", method = RequestMethod.GET, produces = "application/json")
	public CuestionarioCustom getPresupuesto(Model model,@RequestParam("id") int id) {
		Cuestionario cuestionario = cuestionarioService.findById(id);
		CuestionarioCustom cuestionarioCustom = new CuestionarioCustom();
		cuestionarioCustom.setNombre(cuestionario.getTitulo());
		cuestionarioCustom.setFecha(cuestionario.getFecha());
		cuestionarioCustom.setId(cuestionario.getId());
		cuestionarioCustom.setDescuento(cuestionario.getDescuento());
		
		List<Cuestionariopaciente> cuestionarios = cuestionariopacienteService.findByCuestionario(cuestionario);
		
		for (Cuestionariopaciente cuestionariopaciente : cuestionarios) {
	
			if (cuestionariopaciente.getRespuesta_uno().equalsIgnoreCase("SI")) {
				cuestionarioCustom.setTotal_respuesta_uno_si(cuestionarioCustom.getTotal_respuesta_uno_si() + 1);
			} else {
				cuestionarioCustom.setTotal_respuesta_uno_no(cuestionarioCustom.getTotal_respuesta_uno_no() + 1);
			}
			if (cuestionariopaciente.getRespuesta_dos().equalsIgnoreCase("SI")) {
				cuestionarioCustom.setTotal_respuesta_dos_si(cuestionarioCustom.getTotal_respuesta_dos_si() + 1);
			} else {
				cuestionarioCustom.setTotal_respuesta_dos_no(cuestionarioCustom.getTotal_respuesta_dos_no() + 1);
			}
			if (cuestionariopaciente.getRespuesta_tres().equalsIgnoreCase("SI")) {
				cuestionarioCustom.setTotal_respuesta_tres_si(cuestionarioCustom.getTotal_respuesta_tres_si() + 1);
			} else {
				cuestionarioCustom.setTotal_respuesta_tres_no(cuestionarioCustom.getTotal_respuesta_tres_no() + 1);
			}
		}

		return cuestionarioCustom;
	}

}
