package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String comentario;

	private int valor;
	
	private int rutEmisor;
	
	private int rutReceptor;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="evaluacion", fetch=FetchType.EAGER)
	private List<Atencion> atencions;

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

	public Object getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setEvaluacion(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setEvaluacion(null);

		return atencion;
	}

	public int getRutEmisor() {
		return rutEmisor;
	}

	public void setRutEmisor(int rutEmisor) {
		this.rutEmisor = rutEmisor;
	}

	public int getRutReceptor() {
		return rutReceptor;
	}

	public void setRutReceptor(int rutReceptor) {
		this.rutReceptor = rutReceptor;
	}

}