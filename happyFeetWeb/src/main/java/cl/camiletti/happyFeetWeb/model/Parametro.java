package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String decripcion;

	private int numero;

	private String valor;

	//bi-directional many-to-one association to Agenda
	@OneToMany(mappedBy="paramEstadoAgenda")
	private List<Agenda> agendasPorEstados;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="paramEstadoHorario")
	private List<Horario> horariosPorEstado;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="paramSexo")
	private List<Paciente> pacientesPorSexo;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="paramEstadoPaciente")
	private List<Paciente> pacientesPorEstado;

	//bi-directional many-to-one association to Podologo
	@OneToMany(mappedBy="paramEstadoPodologo")
	private List<Podologo> podologosPorEstado;

	//bi-directional many-to-one association to Podologo
	@OneToMany(mappedBy="paramSexo")
	private List<Podologo> podologosPorSexo;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="paramSexo")
	private List<Solicitud> solicitudesPorSexo;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="paramEstadoSolicitud")
	private List<Solicitud> solicitudesPorEstado;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="paramTipoUsuario")
	private List<Usuario> usuariosPorTipo;

	@OneToMany(mappedBy="paramEstadoSolicitudAtencion")
	private List<Solicitudatencion> solicitudesAtencionPorEstado;

	

	public Parametro() {
	}

	public Parametro(int id) {
		this.id=id;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDecripcion() {
		return this.decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public List<Agenda> getAgendas() {
		return this.agendasPorEstados;
	}

	public void setAgendas(List<Agenda> agendasPorEstados) {
		this.agendasPorEstados = agendasPorEstados;
	}

	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setParamEstadoAgenda(this);
		return agenda;
	}

	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setParamEstadoAgenda(null);

		return agenda;
	}

	public List<Horario> getHorariosPorEstado() {
		return this.horariosPorEstado;
	}

	public void setHorariosPorEstado(List<Horario> horariosPorEstado) {
		this.horariosPorEstado = horariosPorEstado;
	}

	public Horario addHorario(Horario horario) {
		getHorariosPorEstado().add(horario);
		horario.setParamEstadoHorario(this);
		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorariosPorEstado().remove(horario);
		horario.setParamEstadoHorario(null);

		return horario;
	}

	public List<Paciente> getPacientesPorSexo() {
		return this.pacientesPorSexo;
	}

	public void setPacientesPorSexo(List<Paciente> pacientesPorSexo) {
		this.pacientesPorSexo = pacientesPorSexo;
	}

	public Paciente addPacientesPorSexo(Paciente pacientesPorSexo) {
		getPacientesPorSexo().add(pacientesPorSexo);
		pacientesPorSexo.setParamSexo(this);

		return pacientesPorSexo;
	}

	public Paciente removePacientesPorSexo(Paciente pacientesPorSexo) {
		getPacientesPorSexo().remove(pacientesPorSexo);
		pacientesPorSexo.setParamSexo(null);;

		return pacientesPorSexo;
	}

	public List<Paciente> getPacientesPorEstado() {
		return this.pacientesPorEstado;
	}

	public void setPacientesPorEstado(List<Paciente> pacientesPorEstado) {
		this.pacientesPorEstado = pacientesPorEstado;
	}

	public Paciente addPacientesPorEstado(Paciente pacientesPorEstado) {
		getPacientesPorEstado().add(pacientesPorEstado);
		pacientesPorEstado.setParamEstadoPaciente(this);

		return pacientesPorEstado;
	}

	public Paciente removePacientesPorEstado(Paciente pacientesPorEstado) {
		getPacientesPorEstado().remove(pacientesPorEstado);
		pacientesPorEstado.setParamEstadoPaciente(null);

		return pacientesPorEstado;
	}

	public List<Podologo> getPodologosPorEstado() {
		return this.podologosPorEstado;
	}

	public void setPodologosPorEstado(List<Podologo> podologosPorEstado) {
		this.podologosPorEstado = podologosPorEstado;
	}

	public Podologo addPodologosPorEstado(Podologo podologosPorEstado) {
		getPodologosPorEstado().add(podologosPorEstado);
		podologosPorEstado.setParamEstadoPodologo(this);

		return podologosPorEstado;
	}

	public Podologo removePodologosPorEstado(Podologo podologosPorEstado) {
		getPodologosPorEstado().remove(podologosPorEstado);
		podologosPorEstado.setParamEstadoPodologo(null);

		return podologosPorEstado;
	}

	public List<Podologo> getPodologosPorSexo() {
		return this.podologosPorSexo;
	}

	public void setPodologosPorSexo(List<Podologo> podologosPorSexo) {
		this.podologosPorSexo = podologosPorSexo;
	}

	public Podologo addPodologosPorSexo(Podologo podologosPorSexo) {
		getPodologosPorSexo().add(podologosPorSexo);
		podologosPorSexo.setParamSexo(this);

		return podologosPorSexo;
	}

	public Podologo removePodologosPorSexo(Podologo podologosPorSexo) {
		getPodologosPorSexo().remove(podologosPorSexo);
		podologosPorSexo.setParamSexo(null);

		return podologosPorSexo;
	}

	public List<Solicitud> getSolicitudesPorSexo() {
		return this.solicitudesPorSexo;
	}

	public void setSolicitudesPorSexo(List<Solicitud> solicitudesPorSexo) {
		this.solicitudesPorSexo = solicitudesPorSexo;
	}

	public Solicitud addSolicitudesPorSexo(Solicitud solicitudesPorSexo) {
		getSolicitudesPorSexo().add(solicitudesPorSexo);
		solicitudesPorSexo.setParamSexo(this);

		return solicitudesPorSexo;
	}

	public Solicitud removeSolicitudesPorSexo(Solicitud solicitudesPorSexo) {
		getSolicitudesPorSexo().remove(solicitudesPorSexo);
		solicitudesPorSexo.setParamSexo(null);

		return solicitudesPorSexo;
	}

	public List<Solicitudatencion> getSolicitudesAtencionPorEstado() {
		return this.solicitudesAtencionPorEstado;
	}

	public void setSolicitudesAtencionPorEstado(List<Solicitudatencion> solicitudesAtencionPorEstado) {
		this.solicitudesAtencionPorEstado = solicitudesAtencionPorEstado;
	}

	public Solicitudatencion addSolicitudesAtencionPorEstado(Solicitudatencion solicitudesAtencionPorEstado) {
		getSolicitudesAtencionPorEstado().add(solicitudesAtencionPorEstado);
		solicitudesAtencionPorEstado.setParamEstadoSolicitudAtencion(this);

		return solicitudesAtencionPorEstado;
	}

	public Solicitudatencion removeSolicitudatencion(Solicitudatencion solicitudesAtencionPorEstado) {
		getSolicitudesPorEstado().remove(solicitudesAtencionPorEstado);
		solicitudesAtencionPorEstado.setParamEstadoSolicitudAtencion(null);

		return solicitudesAtencionPorEstado;
	}

	public List<Usuario> getUsuariosPorTipo() {
		return this.usuariosPorTipo;
	}

	public void setUsuariosPorTipo(List<Usuario> usuariosPorTipo) {
		this.usuariosPorTipo = usuariosPorTipo;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuariosPorTipo().add(usuario);
		usuario.setParamTipoUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuariosPorTipo().remove(usuario);
		usuario.setParamTipoUsuario(null);

		return usuario;
	}
	
	public List<Solicitud> getSolicitudesPorEstado() {
		return this.solicitudesPorEstado;
	}

	public void setSolicitudesPorEstado(List<Solicitud> solicitudesPorEstado) {
		this.solicitudesPorEstado = solicitudesPorEstado;
	}

	public Solicitud addSolicitudesPorEstado(Solicitud solicitudesPorEstado) {
		getSolicitudesPorEstado().add(solicitudesPorEstado);
		solicitudesPorEstado.setParamEstadoSolicitud(this);

		return solicitudesPorEstado;
	}

	public Solicitud removeSolicitudesPorEstado(Solicitud solicitudesPorEstado) {
		getSolicitudesPorEstado().remove(solicitudesPorEstado);
		solicitudesPorEstado.setParamEstadoSolicitud(null);

		return solicitudesPorEstado;
	}

}