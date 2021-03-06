package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the patologia database table.
 * 
 */
@Entity
@NamedQuery(name = "cuestionariopaciente.findAll", query = "SELECT c FROM Cuestionariopaciente c")
public class Cuestionariopaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Cuestionario cuestionario;
	@ManyToOne
	private Paciente paciente;
	private String respuesta_uno;
	private String respuesta_dos;
	private String respuesta_tres;
	@ManyToOne
	@JoinColumn(name = "paramEstadoCuestionario_id")
	private Parametro paramEstadoCuestionario;
	@ManyToOne
	@JoinColumn(name = "paramEstadoDescuento_id")
	private Parametro paramEstadoDescuento;

 

	public int getId() {
		return id;
	}

	public Parametro getParamEstadoDescuento() {
		return paramEstadoDescuento;
	}

	public void setParamEstadoDescuento(Parametro paramEstadoDescuento) {
		this.paramEstadoDescuento = paramEstadoDescuento;
	}
 

	public void setId(int id) {
		this.id = id;
	}

	public Cuestionario getCuestionario() {
		return cuestionario;
	}

	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

 
	public String getRespuesta_uno() {
		return respuesta_uno;
	}

	public void setRespuesta_uno(String respuesta_uno) {
		this.respuesta_uno = respuesta_uno;
	}

	public String getRespuesta_dos() {
		return respuesta_dos;
	}

	public void setRespuesta_dos(String respuesta_dos) {
		this.respuesta_dos = respuesta_dos;
	}

	public String getRespuesta_tres() {
		return respuesta_tres;
	}

	public void setRespuesta_tres(String respuesta_tres) {
		this.respuesta_tres = respuesta_tres;
	}

	public Parametro getParamEstadoCuestionario() {
		return paramEstadoCuestionario;
	}

	public void setParamEstadoCuestionario(Parametro paramEstadoCuestionario) {
		this.paramEstadoCuestionario = paramEstadoCuestionario;
	}

}