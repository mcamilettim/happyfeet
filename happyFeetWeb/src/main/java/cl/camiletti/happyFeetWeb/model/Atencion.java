package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atencion database table.
 * 
 */
@Entity
@NamedQuery(name="atencion.findAll", query="SELECT a FROM Atencion a")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String diagnostico;

	private String foto;

	private String indicaciones;
 
	//bi-directional many-to-one association to Agenda
	@ManyToOne
	private Agenda agenda;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne(cascade = CascadeType.ALL)
	private Evaluacion evaluacion;
	

	public Atencion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIndicaciones() {
		return this.indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
 

	public Agenda getAgenda() {
		return this.agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

 
 
 
}