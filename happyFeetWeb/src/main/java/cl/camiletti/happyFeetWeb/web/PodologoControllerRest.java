package cl.camiletti.happyFeetWeb.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.custom.HorarioCustom;
import cl.camiletti.happyFeetWeb.model.custom.PodologoCustom;
import cl.camiletti.happyFeetWeb.model.custom.PresupuestoCustom;
import cl.camiletti.happyFeetWeb.service.AgendaService;
import cl.camiletti.happyFeetWeb.service.ComunaService;
import cl.camiletti.happyFeetWeb.service.EvaluacionService;
import cl.camiletti.happyFeetWeb.service.HorarioService;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.PatologiaService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.util.Constantes;
import cl.camiletti.happyFeetWeb.util.FileManagerUtil;

@RestController
@RequestMapping("/servicesPodologo")
public class PodologoControllerRest {
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	ComunaService comunaService;
	@Autowired
	EvaluacionService evaluacionService;

	@Autowired
	PatologiaService patologiaServie;

	@Autowired
	PodologoService podologoService;
	
	@Autowired
	AgendaService agendaService;
	
	@Autowired
	HorarioService horarioService;

	@RequestMapping(value = "/podologo/getPodologosPorComuna", method = RequestMethod.GET, produces = "application/json")
	public List<PodologoCustom> cargarPacientes(Model model, @RequestParam("idComuna") int idComuna)
			throws IOException {
		Comuna comuna = comunaService.findById(idComuna);
		List<Ubicacion> ubicaciones = comuna.getUbicacions();
		List<PodologoCustom> podologos = new ArrayList<PodologoCustom>();
		FileManagerUtil fileManagerUtil =new FileManagerUtil();
		  FileManagerUtil fileUtil=new FileManagerUtil();
		for (Ubicacion ubicacion : ubicaciones) {
			for (Podologo podologo : ubicacion.getPodologos()) {
				PodologoCustom podoAux = new PodologoCustom();
				File foto = new File(fileUtil.getROOT_PATH() + File.separator + podologo.getFoto());
				
				if (foto.exists()) {
					podoAux.setFoto(fileManagerUtil
							.encodeFileToBase64Binary(fileUtil.getROOT_PATH() + File.separator + podologo.getFoto()));
				} else {
					podoAux.setFoto(fileManagerUtil
							.encodeFileToBase64Binary(fileUtil.getROOT_PATH() + File.separator + "sinfoto.jpg"));
				}
				podoAux.setNombres(podologo.getNombres());
				podoAux.setApellidos(podologo.getApellidos());
				podoAux.setRut(podologo.getRut());
				Ubicacion ubicacionAux = new Ubicacion();
				ubicacionAux.setLatitud(ubicacion.getLatitud());
				ubicacionAux.setId(ubicacion.getId());
				ubicacionAux.setLongitud(ubicacion.getLongitud());

				podoAux.setUbicacion(ubicacionAux);
				podoAux.setEvaluacion(getEvaluacion(podoAux.getRut()));

				for (Horario horario : podologo.getHorarios()) {
					if (horario.getParamEstadoHorario().getId() == 2) {
						podoAux.getHorarios()
								.add(new HorarioCustom(horario.getId(), horario.getFecha(), horario.getHora(),
										horario.getHoraFin(), horario.getPodologo().getRut(),
										horario.getParamEstadoHorario().getId()));
					}
				}
				podologos.add(podoAux);
			}
		}

		return podologos;
	}

	@RequestMapping(value = "/podologo/getPresupuesto", method = RequestMethod.GET, produces = "application/json")
	public PresupuestoCustom getPresupuesto(Model model, @RequestParam("idPatologia") int idPatologia,
			@RequestParam("rutPodologo") String rutPodologo, @RequestParam("kilometros") String kilometros)
			throws IOException {
		PresupuestoCustom presupuestoCustom = new PresupuestoCustom();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Paciente paciente = pacienteService.findByEmail(user.getUsername());
		Patologia patologia = patologiaServie.findById(idPatologia);
		Podologo podologo = podologoService.find(rutPodologo);
		
		
		presupuestoCustom.setRutPodologo(podologo.getRut());
		presupuestoCustom.setDireccion_origen(podologo.getUbicacion().getNombre());
		presupuestoCustom.setDireccion_destino(paciente.getUbicacion().getNombre());
		presupuestoCustom.setKilometros(kilometros);
		presupuestoCustom.setMontoPorKilometro(Constantes.VALOR_POR_KILOMETRO);
		presupuestoCustom.setPatologia_nombre(patologia.getNombre());
		presupuestoCustom.setPatologia_monto(patologia.getCosto());
		presupuestoCustom.setNombrePodologo(podologo.getNombres() + " " + podologo.getApellidos());
		presupuestoCustom.setEvaluacion(getEvaluacion(podologo.getRut()));
		presupuestoCustom.setMontoKilometros((int) (Double.parseDouble(kilometros) * 1125));
		presupuestoCustom.setPatologia_id(idPatologia);
		presupuestoCustom.setTotal(presupuestoCustom.getMontoKilometros() + presupuestoCustom.getPatologia_monto());
		return presupuestoCustom;
	}
	public Double getEvaluacion(String rut) {
		List<Evaluacion> evaluaciones = evaluacionService.findByRutReceptor(rut);
		double valoracionTotal = 0;
		for (Evaluacion evaluacion : evaluaciones) {
			valoracionTotal = valoracionTotal + evaluacion.getValor();
		}
		if (evaluaciones != null && evaluaciones.size() > 0) {
			return valoracionTotal / evaluaciones.size();
		} else {
			return (double) 5;
		}
	}
}
