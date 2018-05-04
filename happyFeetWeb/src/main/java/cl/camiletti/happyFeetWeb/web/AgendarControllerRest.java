package cl.camiletti.happyFeetWeb.web;

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

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Patologia;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Ubicacion;
import cl.camiletti.happyFeetWeb.model.custom.HorarioCustom;
import cl.camiletti.happyFeetWeb.model.custom.PacienteCustom;
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

@RestController
@RequestMapping("/servicesAgendar")
public class AgendarControllerRest {
	@Autowired
	PacienteService pacienteService;
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

	@RequestMapping(value = "/getPodologosPorComuna", method = RequestMethod.GET, produces = "application/json")
	public List<PodologoCustom> getPodologosPorComuna(Model model, @RequestParam("idComuna") int idComuna)
			throws IOException {
		Comuna comuna = comunaService.findById(idComuna);
		List<Ubicacion> ubicaciones = comuna.getUbicacions();
		List<PodologoCustom> podologos = new ArrayList<PodologoCustom>();

	 
		for (Ubicacion ubicacion : ubicaciones) {
			for (Podologo podologo : ubicacion.getPodologos()) {
				PodologoCustom podoAux = new PodologoCustom();
			     podoAux.setFoto(podologo.getFoto());
				 
				podoAux.setNombres(podologo.getNombres());
				podoAux.setApellidos(podologo.getApellidos());
				podoAux.setRut(podologo.getRut());
				Ubicacion ubicacionAux = new Ubicacion();
				ubicacionAux.setLatitud(ubicacion.getLatitud());
				ubicacionAux.setId(ubicacion.getId());
				ubicacionAux.setLongitud(ubicacion.getLongitud());

				podoAux.setUbicacion(ubicacionAux);
				podoAux.setEvaluacion(getEvaluacion(podologo));

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
	@RequestMapping(value = "/getPaciente", method = RequestMethod.GET, produces = "application/json")
	public PacienteCustom getPaciente(Model model) {
		PacienteCustom custom=null;
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			custom=new PacienteCustom();
			Paciente paciente = pacienteService.findByEmail(user.getUsername()); 
			Ubicacion ubicacionAux=new Ubicacion();
		
			ubicacionAux.setLatitud(paciente.getUbicacion().getLatitud());
			ubicacionAux.setLongitud(paciente.getUbicacion().getLongitud());
			ubicacionAux.setId(paciente.getUbicacion().getId());
			ubicacionAux.setNombre(paciente.getUbicacion().getNombre());
			
			Comuna comunaAux=new Comuna();
			comunaAux.setId(paciente.getUbicacion().getComuna().getId());
			comunaAux.setNombre(paciente.getUbicacion().getComuna().getNombre());
			ubicacionAux.setComuna(comunaAux);
			
			custom.setUbicacion(ubicacionAux);
			custom.setNombres(paciente.getNombres());
			custom.setApellidos(paciente.getApellidos());
			custom.setRut(paciente.getRut());
			
		} catch (Exception e) {
			custom=null;
		}
		
		 
		return custom;
	}
	@RequestMapping(value = "/getPresupuesto", method = RequestMethod.GET, produces = "application/json")
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
		presupuestoCustom.setEvaluacion(getEvaluacion(podologo));
		presupuestoCustom.setMontoKilometros((int) (Double.parseDouble(kilometros) * 1125));
		presupuestoCustom.setPatologia_id(idPatologia);
		presupuestoCustom.setTotal(presupuestoCustom.getMontoKilometros() + presupuestoCustom.getPatologia_monto());
		return presupuestoCustom;
	}
	public Double getEvaluacion(Podologo podologo) {
		List<Evaluacion> evaluaciones = evaluacionService.findByPodologo(podologo);
		double valoracionTotal = 0;
		for (Evaluacion evaluacion : evaluaciones) {
			valoracionTotal = valoracionTotal + evaluacion.getValorPodologo();
		}
		if (evaluaciones != null && evaluaciones.size() > 0) {
			return valoracionTotal / evaluaciones.size();
		} else {
			return (double) 5;
		}
	}
}
