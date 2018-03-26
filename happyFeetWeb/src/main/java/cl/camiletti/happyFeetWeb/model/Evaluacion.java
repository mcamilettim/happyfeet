package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String comentario;

	private int valor;

	private String rutEmisor;

	private String rutReceptor;

	public Evaluacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getRutEmisor() {
		return rutEmisor;
	}

	public void setRutEmisor(String rutEmisor) {
		this.rutEmisor = rutEmisor;
	}

	public String getRutReceptor() {
		return rutReceptor;
	}

	public void setRutReceptor(String rutReceptor) {
		this.rutReceptor = rutReceptor;
	}

}