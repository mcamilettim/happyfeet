package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String fecha;

	private String hora;
	
	private String horaFin;

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	//bi-directional many-to-one association to Agenda
	@OneToMany(mappedBy="horario", fetch=FetchType.EAGER)
	private List<Agenda> agendas;

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="paramEstadoHorario_id")
	private Parametro paramEstadoHorario;

	//bi-directional many-to-one association to Podologo
	@ManyToOne
	private Podologo podologo;

	//bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy="horario", fetch=FetchType.EAGER)
	private List<Solicitudatencion> solicitudatencions;

	public Horario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setHorario(this);

		return agenda;
	}

	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setHorario(null);

		return agenda;
	}

	public Parametro getParamEstadoHorario() {
		return this.paramEstadoHorario;
	}

	public void setParamEstadoHorario(Parametro paramEstadoHorario) {
		this.paramEstadoHorario = paramEstadoHorario;
	}

	public Podologo getPodologo() {
		return this.podologo;
	}

	public void setPodologo(Podologo podologo) {
		this.podologo = podologo;
	}

	public List<Solicitudatencion> getSolicitudatencions() {
		return this.solicitudatencions;
	}

	public void setSolicitudatencions(List<Solicitudatencion> solicitudatencions) {
		this.solicitudatencions = solicitudatencions;
	}

	public Solicitudatencion addSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().add(solicitudatencion);
		solicitudatencion.setHorario(this);

		return solicitudatencion;
	}

	public Solicitudatencion removeSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().remove(solicitudatencion);
		solicitudatencion.setHorario(null);

		return solicitudatencion;
	}

}