package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the podologo database table.
 * 
 */
@Entity
@NamedQuery(name = "podologo.findAll", query = "SELECT p FROM Podologo p")
public class Podologo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String rut;

	private String apellidos;

	private String email;

	private String fono;

	private String foto;

	private String nombres;

	 

	// bi-directional many-to-one association to Horario
	@OneToMany(mappedBy = "podologo", fetch = FetchType.EAGER)
	private List<Horario> horarios;

	// bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name = "paramEstadoPodologo_id")
	private Parametro paramEstadoPodologo;

	// bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name = "paramSexo_id")
	private Parametro paramSexo;

	// bi-directional many-to-one association to Ubicacion
	@ManyToOne
	private Ubicacion ubicacion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	// bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy = "podologo", fetch = FetchType.EAGER)
	private List<Solicitudatencion> solicitudatencions;
	// bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy = "podologo", fetch = FetchType.EAGER)
	private List<Agenda> agendas;

	public Podologo() {
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFono() {
		return this.fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
 
	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setPodologo(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setPodologo(null);

		return horario;
	}

	public Parametro getParamEstadoPodologo() {
		return this.paramEstadoPodologo;
	}

	public void setParamEstadoPodologo(Parametro paramEstadoPodologo) {
		this.paramEstadoPodologo = paramEstadoPodologo;
	}

	public Parametro getParamSexo() {
		return this.paramSexo;
	}

	public void setParamSexo(Parametro paramSexo) {
		this.paramSexo = paramSexo;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Solicitudatencion> getSolicitudatencions() {
		return this.solicitudatencions;
	}

	public void setSolicitudatencions(List<Solicitudatencion> solicitudatencions) {
		this.solicitudatencions = solicitudatencions;
	}

	public Solicitudatencion addSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().add(solicitudatencion);
		solicitudatencion.setPodologo(this);

		return solicitudatencion;
	}

	public Solicitudatencion removeSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().remove(solicitudatencion);
		solicitudatencion.setPodologo(null);

		return solicitudatencion;
	}

}