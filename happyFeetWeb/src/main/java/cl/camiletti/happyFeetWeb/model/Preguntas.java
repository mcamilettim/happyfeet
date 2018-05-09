package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the patologia database table.
 * 
 */
@Entity
@NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
public class Preguntas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String pregunta_uno;

	private String pregunta_dos;

	private String pregunta_tres;

	
	// bi-directional many-to-one association to Cuestionario
	@OneToMany(mappedBy = "preguntas", fetch = FetchType.EAGER)
	private List<Cuestionario> cuestionarios;
	
	
	public List<Cuestionario> getCuestionarios() {
		return cuestionarios;
	}

	public void setCuestionarios(List<Cuestionario> cuestionarios) {
		this.cuestionarios = cuestionarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPregunta_uno() {
		return pregunta_uno;
	}

	public void setPregunta_uno(String pregunta_uno) {
		this.pregunta_uno = pregunta_uno;
	}

	public String getPregunta_dos() {
		return pregunta_dos;
	}

	public void setPregunta_dos(String pregunta_dos) {
		this.pregunta_dos = pregunta_dos;
	}

	public String getPregunta_tres() {
		return pregunta_tres;
	}

	public void setPregunta_tres(String pregunta_tres) {
		this.pregunta_tres = pregunta_tres;
	}

}