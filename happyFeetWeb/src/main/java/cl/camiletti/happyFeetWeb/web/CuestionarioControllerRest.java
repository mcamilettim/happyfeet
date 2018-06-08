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
import cl.camiletti.happyFeetWeb.model.Cuestionariopodologo;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.custom.CuestionarioCustom;
import cl.camiletti.happyFeetWeb.service.CuestionarioService;
import cl.camiletti.happyFeetWeb.service.CuestionariopacienteService;
import cl.camiletti.happyFeetWeb.service.CuestionariopodologoService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.util.Parametros;

@RestController
@RequestMapping("/servicesCuestionario")
public class CuestionarioControllerRest {
	@Autowired
	private CuestionarioService cuestionarioService;
	@Autowired
	private CuestionariopacienteService cuestionariopacienteService;
	@Autowired
	private CuestionariopodologoService cuestionariopodologoService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private PodologoService podologoService;
	@Autowired
	ParametroService parametroService;

	@RequestMapping(value = "/getCuestionario", method = RequestMethod.GET, produces = "application/json")
	public CuestionarioCustom getPresupuesto(Model model, @RequestParam("id") int id) {
		Cuestionario cuestionario = cuestionarioService.findById(id);

		CuestionarioCustom cuestionarioCustom = new CuestionarioCustom();
		
	
		cuestionarioCustom.setTipo(cuestionario.getTipo());
		cuestionarioCustom.setNombre(cuestionario.getTitulo());
		cuestionarioCustom.setFecha(cuestionario.getFecha());
		cuestionarioCustom.setId(cuestionario.getId());
		cuestionarioCustom.setDescuento(cuestionario.getDescuento());
		Parametro paramResuelto = parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_RESUELTO);
		if (cuestionarioCustom.getTipo().equals(Parametros.ESTADO_TIPO_CUESTIONARIO_PACIENTE)) {
			cuestionarioCustom.setTotal_paciente(pacienteService.findAll().size());
			List<Cuestionariopaciente> totalCuestionarioPaciente = cuestionariopacienteService
					.findByCuestionarioAndParamEstadoCuestionario(cuestionario,
							parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_PENDIENTE));

			cuestionarioCustom.setTotal_cuestionario_paciente_pendiente(totalCuestionarioPaciente.size());

			totalCuestionarioPaciente = cuestionariopacienteService
					.findByCuestionarioAndParamEstadoCuestionario(cuestionario, paramResuelto);
			cuestionarioCustom.setTotal_cuestionario_paciente_respondido(totalCuestionarioPaciente.size());
			int resultado = 0;
			for (Cuestionariopaciente cuestionariopaciente : totalCuestionarioPaciente) {

				if (cuestionariopaciente.getRespuesta_uno().equalsIgnoreCase("SI")) {
					resultado = resultado + 1;
					cuestionarioCustom.setTotal_respuesta_uno_si(cuestionarioCustom.getTotal_respuesta_uno_si() + 1);
				} else {
					cuestionarioCustom.setTotal_respuesta_uno_no(cuestionarioCustom.getTotal_respuesta_uno_no() + 1);
					resultado = resultado - 1;
				}
				if (cuestionariopaciente.getRespuesta_dos().equalsIgnoreCase("SI")) {
					cuestionarioCustom.setTotal_respuesta_dos_si(cuestionarioCustom.getTotal_respuesta_dos_si() + 1);
					resultado = resultado + 1;
				} else {
					cuestionarioCustom.setTotal_respuesta_dos_no(cuestionarioCustom.getTotal_respuesta_dos_no() + 1);
					resultado = resultado - 1;
				}
				if (cuestionariopaciente.getRespuesta_tres().equalsIgnoreCase("SI")) {
					cuestionarioCustom.setTotal_respuesta_tres_si(cuestionarioCustom.getTotal_respuesta_tres_si() + 1);
					resultado = resultado + 1;
				} else {
					cuestionarioCustom.setTotal_respuesta_tres_no(cuestionarioCustom.getTotal_respuesta_tres_no() + 1);
					resultado = resultado - 1;
				}

				if (resultado == -3)
					cuestionarioCustom
							.setTotal_paciente_insatisfecho(cuestionarioCustom.getTotal_paciente_insatisfecho() + 1);
				if (resultado == -1)
					cuestionarioCustom
							.setTotal_paciente_insatisfecho(cuestionarioCustom.getTotal_paciente_insatisfecho() + 1);
				if (resultado == 1)
					cuestionarioCustom
							.setTotal_paciente_satisfecho(cuestionarioCustom.getTotal_paciente_satisfecho() + 1);
				if (resultado == 3)
					cuestionarioCustom
							.setTotal_paciente_satisfecho(cuestionarioCustom.getTotal_paciente_satisfecho() + 1);

				resultado = 0;
			}

		} else {
			cuestionarioCustom.setTotal_podologo(podologoService.findAll().size());
			List<Cuestionariopodologo> totalCuestionarioPodologo = cuestionariopodologoService
					.findByCuestionarioAndParamEstadoCuestionario(cuestionario,
							parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_PENDIENTE));

			cuestionarioCustom.setTotal_cuestionario_podologo_pendiente(totalCuestionarioPodologo.size());

			totalCuestionarioPodologo = cuestionariopodologoService.findByCuestionarioAndParamEstadoCuestionario(
					cuestionario, parametroService.findOne(Parametros.ESTADO_CUESTIONARIO_RESUELTO));

			cuestionarioCustom.setTotal_cuestionario_podologo_respondido(totalCuestionarioPodologo.size());
			int resultado = 0;
			for (Cuestionariopodologo cuestionariopodologo : totalCuestionarioPodologo) {

				if (cuestionariopodologo.getRespuesta_uno().equalsIgnoreCase("SI")) {
					resultado = resultado + 1;
					cuestionarioCustom.setTotal_respuesta_uno_si(cuestionarioCustom.getTotal_respuesta_uno_si() + 1);
				} else {
					cuestionarioCustom.setTotal_respuesta_uno_no(cuestionarioCustom.getTotal_respuesta_uno_no() + 1);
					resultado = resultado - 1;
				}
				if (cuestionariopodologo.getRespuesta_dos().equalsIgnoreCase("SI")) {
					cuestionarioCustom.setTotal_respuesta_dos_si(cuestionarioCustom.getTotal_respuesta_dos_si() + 1);
					resultado = resultado + 1;
				} else {
					cuestionarioCustom.setTotal_respuesta_dos_no(cuestionarioCustom.getTotal_respuesta_dos_no() + 1);
					resultado = resultado - 1;
				}
				if (cuestionariopodologo.getRespuesta_tres().equalsIgnoreCase("SI")) {
					cuestionarioCustom.setTotal_respuesta_tres_si(cuestionarioCustom.getTotal_respuesta_tres_si() + 1);
					resultado = resultado + 1;
				} else {
					cuestionarioCustom.setTotal_respuesta_tres_no(cuestionarioCustom.getTotal_respuesta_tres_no() + 1);
					resultado = resultado - 1;
				}

				if (resultado == -3)
					cuestionarioCustom
							.setTotal_podologo_insatisfecho(cuestionarioCustom.getTotal_podologo_insatisfecho() + 1);
				if (resultado == -1)
					cuestionarioCustom
							.setTotal_podologo_insatisfecho(cuestionarioCustom.getTotal_podologo_insatisfecho() + 1);
				if (resultado == 1)
					cuestionarioCustom
							.setTotal_podologo_satisfecho(cuestionarioCustom.getTotal_podologo_satisfecho() + 1);
				if (resultado == 3)
					cuestionarioCustom
							.setTotal_podologo_satisfecho(cuestionarioCustom.getTotal_podologo_satisfecho() + 1);

				resultado = 0;
			}
		}
		return cuestionarioCustom;
	}
}
