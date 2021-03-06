package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the solicitudatencion database table.
 * 
 */
@Entity
@NamedQuery(name="solicitudatencion.findAll", query="SELECT s FROM Solicitudatencion s")
public class Solicitudatencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String comentarioPaciente;
	private String comentarioPodologo;
	private String fotoPiePath;
	
	private String fechaSolicitud;
	
	private String fotoViajePath;
	//bi-directional many-to-one association to Horario
	@ManyToOne
	private Horario horario;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	private Paciente paciente;

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="paramEstadoSolicitudAtencion_id")
	private Parametro paramEstadoSolicitudAtencion;

	//bi-directional many-to-one association to Patologia
	@ManyToOne
	private Patologia patologia;

	//bi-directional many-to-one association to Podologo
	@ManyToOne
	private Podologo podologo;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne(cascade = {CascadeType.ALL})
	private Presupuesto presupuesto;

	public Solicitudatencion() {
	}

	public String getFotoViajePath() {
		return fotoViajePath;
	}

	public void setFotoViajePath(String fotoViajePath) {
		this.fotoViajePath = fotoViajePath;
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

	public String getFotoPiePath() {
		return this.fotoPiePath;
	}

	public void setFotoPiePath(String fotoPiePath) {
		this.fotoPiePath = fotoPiePath;
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

	public Parametro getParamEstadoSolicitudAtencion() {
		return this.paramEstadoSolicitudAtencion;
	}

	public void setParamEstadoSolicitudAtencion(Parametro paramEstadoSolicitudAtencion) {
		this.paramEstadoSolicitudAtencion = paramEstadoSolicitudAtencion;
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
	
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

}