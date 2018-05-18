package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name = "evaluacion.findAll", query = "SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String comentarioPaciente;
	private String comentarioPodologo;
	private int valorPodologo;
	private int valorPaciente;
	
	@ManyToOne
	private Paciente paciente;

	// bi-directional many-to-one association to Paciente
	@ManyToOne
	private Podologo podologo;

	public Evaluacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
 

	public String getComentarioPaciente() {
		return comentarioPaciente;
	}

	public void setComentarioPaciente(String comentarioPaciente) {
		this.comentarioPaciente = comentarioPaciente;
	}

	public String getComentarioPodologo() {
		return comentarioPodologo;
	}

	public void setComentarioPodologo(String comentarioPodologo) {
		this.comentarioPodologo = comentarioPodologo;
	}

 

	public int getValorPodologo() {
		return valorPodologo;
	}

	public void setValorPodologo(int valorPodologo) {
		this.valorPodologo = valorPodologo;
	}

	public int getValorPaciente() {
		return valorPaciente;
	}

	public void setValorPaciente(int valorPaciente) {
		this.valorPaciente = valorPaciente;
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

 
}