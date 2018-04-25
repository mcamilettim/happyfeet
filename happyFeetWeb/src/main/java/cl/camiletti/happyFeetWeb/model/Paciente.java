package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rut;

	private String apellidos;

	private String diabetico;

	private int edad;

	private String email;

	private String fechaNacimiento;

	private String fechaUltimaAtencion;

	private String fono;

	private String foto;

	private String nombres;

 

	//bi-directional many-to-one association to Agenda
	@OneToMany(mappedBy="paciente", fetch=FetchType.EAGER)
	private List<Agenda> agendas;


	//bi-directional many-to-one association to Parametro
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="paramSexo_id")
	private Parametro paramSexo;

	//bi-directional many-to-one association to Parametro
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="paramEstadoPaciente_id")
	private Parametro paramEstadoPaciente;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne(cascade = CascadeType.ALL)
	private Ubicacion ubicacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	//bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy="paciente", fetch=FetchType.EAGER)
	private List<Solicitudatencion> solicitudatencions;
	
	//bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy="paciente", fetch=FetchType.EAGER)
	private List<Notificacionpaciente> notificacion;

	public Paciente() {
	}

	public List<Notificacionpaciente> getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(List<Notificacionpaciente> notificacion) {
		this.notificacion = notificacion;
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

	public String getDiabetico() {
		return this.diabetico;
	}

	public void setDiabetico(String diabetico) {
		this.diabetico = diabetico;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaUltimaAtencion() {
		return this.fechaUltimaAtencion;
	}

	public void setFechaUltimaAtencion(String fechaUltimaAtencion) {
		this.fechaUltimaAtencion = fechaUltimaAtencion;
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

	 
	public List<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setPaciente(this);

		return agenda;
	}

	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setPaciente(null);

		return agenda;
	}



	public Parametro getParamSexo() {
		return this.paramSexo;
	}

	public void setParamSexo(Parametro paramSexo) {
		this.paramSexo = paramSexo;
	}

	public Parametro getParamEstadoPaciente() {
		return this.paramEstadoPaciente;
	}

	public void setParamEstadoPaciente(Parametro paramEstadoPaciente) {
		this.paramEstadoPaciente = paramEstadoPaciente;
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
		solicitudatencion.setPaciente(this);

		return solicitudatencion;
	}

	public Solicitudatencion removeSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().remove(solicitudatencion);
		solicitudatencion.setPaciente(null);

		return solicitudatencion;
	}

}