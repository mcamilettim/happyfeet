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
@NamedQuery(name = "Cuestionariopaciente.findAll", query = "SELECT c FROM Cuestionariopaciente c")
public class Cuestionariopaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Cuestionario cuestionario;
	@ManyToOne
	private Paciente  paciente;	 
	private int respuesta_uno;
	private int respuesta_dos;
	private int respuesta_tres;
	@ManyToOne
	@JoinColumn(name = "paramEstadoCuestionario_id")
	private Parametro paramEstadoCuestionario;
	
	public int getId() {
		return id;
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
	public int getRespuesta_uno() {
		return respuesta_uno;
	}
	public void setRespuesta_uno(int respuesta_uno) {
		this.respuesta_uno = respuesta_uno;
	}
	public int getRespuesta_dos() {
		return respuesta_dos;
	}
	public void setRespuesta_dos(int respuesta_dos) {
		this.respuesta_dos = respuesta_dos;
	}
	public int getRespuesta_tres() {
		return respuesta_tres;
	}
	public void setRespuesta_tres(int respuesta_tres) {
		this.respuesta_tres = respuesta_tres;
	}
	public Parametro getParamEstadoCuestionario() {
		return paramEstadoCuestionario;
	}
	public void setParamEstadoCuestionario(Parametro paramEstadoCuestionario) {
		this.paramEstadoCuestionario = paramEstadoCuestionario;
	}

	
	 
}