package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mensaje database table.
 * 
 */
@Entity
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cuerpo;
	private String fecha;
	private String hora;
	@Column(name="emisor_rut")
	private String emisorRut;

	@Column(name="receptor_rut")
	private String receptorRut;

	@ManyToOne
	@JoinColumn(name = "paramEstadoMensaje_id")
	private Parametro paramEstadoMensaje;
	
	public Mensaje() {
	}

	public Parametro getParamEstadoMensaje() {
		return paramEstadoMensaje;
	}

	public void setParamEstadoMensaje(Parametro paramEstadoMensaje) {
		this.paramEstadoMensaje = paramEstadoMensaje;
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuerpo() {
		return this.cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getEmisorRut() {
		return this.emisorRut;
	}

	public void setEmisorRut(String emisorRut) {
		this.emisorRut = emisorRut;
	}

	public String getReceptorRut() {
		return this.receptorRut;
	}

	public void setReceptorRut(String receptorRut) {
		this.receptorRut = receptorRut;
	}

}