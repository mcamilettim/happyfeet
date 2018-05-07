package cl.camiletti.happyFeetWeb.model.custom;

import java.util.ArrayList;
import java.util.List;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.PodologoService;

public class MensajeCustom {
	private String cuerpo;
	private String fecha;
	private String hora;
	private String titulo;
	private Paciente paciente;

	private Podologo podologo;

	public MensajeCustom(String cuerpo, String fecha, String hora, String titulo, Paciente paciente,
			Podologo podologo) {
		super();
		this.cuerpo = cuerpo;
		this.fecha = fecha;
		this.hora = hora;
		this.titulo = titulo;
		this.paciente = paciente;
		this.podologo = podologo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Podologo getPodologo() {
		return podologo;
	}

	public void setPodologo(Podologo podologo) {
		this.podologo = podologo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static ArrayList<MensajeCustom> cargarMensajesNoVistosPaciente(List<Mensaje> mensajes,
			PacienteService pacienteService, PodologoService podologoService) {
		ArrayList<MensajeCustom> mensajesCustom = new ArrayList<MensajeCustom>();
		Paciente paciente = null;
		String titulo = null;
		Podologo podologo = null;
		for (Mensaje mensaje : mensajes) {
			if (paciente == null)
				paciente = pacienteService.find(mensaje.getReceptorRut());
			if (mensaje.getCuerpo().length() > 45) {
				titulo = mensaje.getCuerpo().substring(0, 44) + " ...";
			} else {
				titulo = mensaje.getCuerpo();
			}
			podologo = podologoService.find(mensaje.getEmisorRut());
			if(podologo!=null)
				if(!existPodologo(mensajesCustom, podologo))
			mensajesCustom.add(new MensajeCustom(mensaje.getCuerpo(), mensaje.getFecha(), mensaje.getHora(),
					titulo, paciente, podologo));
		}
		return mensajesCustom;
	}
	public static ArrayList<MensajeCustom> cargarMensajesNoVistosPodologo(List<Mensaje> mensajes,
			PacienteService pacienteService, PodologoService podologoService) {
		ArrayList<MensajeCustom> mensajesCustom = new ArrayList<MensajeCustom>();
		Paciente paciente = null;
		String titulo = null;
		Podologo podologo = null;
		for (Mensaje mensaje : mensajes) {
			if (paciente == null)
				paciente = pacienteService.find(mensaje.getEmisorRut());
			if (mensaje.getCuerpo().length() > 45) {
				titulo = mensaje.getCuerpo().substring(0, 44) + " ...";
			} else {
				titulo = mensaje.getCuerpo();
			}
			podologo = podologoService.find(mensaje.getReceptorRut());
			if(podologo!=null)
				if(!existPodologo(mensajesCustom, podologo))
			mensajesCustom.add(new MensajeCustom(mensaje.getCuerpo(), mensaje.getFecha(), mensaje.getHora(),
					titulo, paciente, podologo));
		}
		return mensajesCustom;
	}
	public static ArrayList<MensajeCustom> cargarMensajesVistos(List<Mensaje> mensajesNoVistos,
			PacienteService pacienteService, PodologoService podologoService,List<Mensaje> mensajesVistos) {
		ArrayList<MensajeCustom> mensajesCustom = new ArrayList<MensajeCustom>();
		Paciente paciente = null;
		String titulo = null;
		Podologo podologo = null;
		for (Mensaje mensaje : mensajesVistos) {
			if (paciente == null)
				paciente = pacienteService.find(mensaje.getReceptorRut());
			if (mensaje.getCuerpo().length() > 45) {
				titulo = mensaje.getCuerpo().substring(0, 44) + " ...";
			} else {
				titulo = mensaje.getCuerpo();
			}
			podologo = podologoService.find(mensaje.getEmisorRut());
			if(podologo!=null)
			if(!existPodologo(mensajesCustom, podologo))
				if(!existPodologo(mensajesNoVistos, podologo))
			mensajesCustom.add(new MensajeCustom(mensaje.getCuerpo(), mensaje.getFecha(), mensaje.getHora(),
					titulo, paciente, podologo));
		}
		return mensajesCustom;
	}
	public static ArrayList<MensajeCustom> cargarMensajesVistosPodologo(List<Mensaje> mensajesNoVistos,
			PacienteService pacienteService, PodologoService podologoService,List<Mensaje> mensajesVistos) {
		ArrayList<MensajeCustom> mensajesCustom = new ArrayList<MensajeCustom>();
		Paciente paciente = null;
		String titulo = null;
		Podologo podologo = null;
		for (Mensaje mensaje : mensajesVistos) {
			if (paciente == null)
				paciente = pacienteService.find(mensaje.getEmisorRut());
			if (mensaje.getCuerpo().length() > 45) {
				titulo = mensaje.getCuerpo().substring(0, 44) + " ...";
			} else {
				titulo = mensaje.getCuerpo();
			}
			podologo = podologoService.find(mensaje.getReceptorRut());
			if(podologo!=null)
			if(!existPodologo(mensajesCustom, podologo))
				if(!existPodologo(mensajesNoVistos, podologo))
			mensajesCustom.add(new MensajeCustom(mensaje.getCuerpo(), mensaje.getFecha(), mensaje.getHora(),
					titulo, paciente, podologo));
		}
		return mensajesCustom;
	}
	public static boolean existPodologo(ArrayList<MensajeCustom> mensajesCustom, Podologo podologo) {
		for (MensajeCustom mensajeCustomPaciente : mensajesCustom) {
			if(mensajeCustomPaciente.getPodologo().getRut().equals(podologo.getRut()))
				return true;
		}
		return false;
	}
	public static boolean existPodologo(List<Mensaje> mensajes, Podologo podologo) {
		for (Mensaje mensajitos : mensajes) {
			if(mensajitos.getEmisorRut().equals(podologo.getRut()))
				return true;
		}
		return false;
	}
}
