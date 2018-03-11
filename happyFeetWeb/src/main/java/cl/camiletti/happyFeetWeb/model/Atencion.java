package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atencion database table.
 * 
 */
@Entity
@NamedQuery(name="Atencion.findAll", query="SELECT a FROM Atencion a")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String diagnostico;

	private String foto;

	private String indicaciones;

	private int montoCancelado;

	//bi-directional many-to-one association to Agenda
	@ManyToOne
	private Agenda agenda;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne
	private Evaluacion evaluacion;

	//bi-directional many-to-one association to Patologia
	@ManyToOne
	private Patologia patologia;

	//bi-directional many-to-one association to Podologo
	@ManyToOne
	private Podologo podologo;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne
	private Presupuesto presupuesto;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	private Ubicacion ubicacion;

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

	public int getMontoCancelado() {
		return this.montoCancelado;
	}

	public void setMontoCancelado(int montoCancelado) {
		this.montoCancelado = montoCancelado;
	}

	public Agenda getAgenda() {
		return this.agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Evaluacion getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Patologia getPatologia() {
		return this.patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public Podologo getPodologo() {
		return this.podologo;
	}

	public void setPodologo(Podologo podologo) {
		this.podologo = podologo;
	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

}