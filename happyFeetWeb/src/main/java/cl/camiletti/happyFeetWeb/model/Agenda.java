package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String comentario;

	private String fotoPiePath;
	
	private String fotoViajePath;

	private String fechaAgenda;
	// bi-directional many-to-one association to Patologia
	@ManyToOne
	private Patologia patologia;

	// bi-directional many-to-one association to Presupuesto
	@ManyToOne(cascade = { CascadeType.ALL })
	private Presupuesto presupuesto;

	// bi-directional many-to-one association to Horario
	@ManyToOne
	private Horario horario;

	// bi-directional many-to-one association to Paciente
	@ManyToOne
	private Paciente paciente;

	// bi-directional many-to-one association to Paciente
	@ManyToOne
	private Podologo podologo;

	// bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name = "paramEstadoAgenda_id")
	private Parametro paramEstadoAgenda;

	// bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy = "agenda", fetch = FetchType.EAGER)
	private List<Atencion> atencions;

	public Podologo getPodologo() {
		return podologo;
	}

	public String getFotoViajePath() {
		return fotoViajePath;
	}

	public void setFotoViajePath(String fotoViajePath) {
		this.fotoViajePath = fotoViajePath;
	}

	public void setPodologo(Podologo podologo) {
		this.podologo = podologo;
	}

	public String getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda(String fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	public Agenda() {
	}

	public int getId() {
		return this.id;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
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

	public String getFotoPiePath() {
		return fotoPiePath;
	}

	public void setFotoPiePath(String fotoPiePath) {
		this.fotoPiePath = fotoPiePath;
	}

	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Parametro getParamEstadoAgenda() {
		return this.paramEstadoAgenda;
	}

	public void setParamEstadoAgenda(Parametro paramEstadoAgenda) {
		this.paramEstadoAgenda = paramEstadoAgenda;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setAgenda(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setAgenda(null);

		return atencion;
	}

}