package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "notificacionpaciente.findAll", query = "SELECT e FROM Notificacionpaciente e")
public class Notificacionpaciente  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String mensaje;
	private String url;
	private String titulo;
	private String fecha;
	private String hora;
	@ManyToOne
	@JoinColumn(name = "paramEstadoNotificacion_id")
	private Parametro paramEstadoNotificacion;

	@ManyToOne
	private Paciente paciente;

	public Notificacionpaciente() {
	}

	public Parametro getParamEstadoNotificacion() {
		return paramEstadoNotificacion;
	}

	public void setParamEstadoNotificacion(Parametro paramEstadoNotificacion) {
		this.paramEstadoNotificacion = paramEstadoNotificacion;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
