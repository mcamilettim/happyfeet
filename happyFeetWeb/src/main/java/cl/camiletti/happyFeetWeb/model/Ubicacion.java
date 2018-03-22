package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String latitud;

	private String longitud;

	private String nombre;
	
	private String pathFoto;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="ubicacion", fetch=FetchType.EAGER)
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="ubicacion", fetch=FetchType.EAGER)
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Podologo
	@OneToMany(mappedBy="ubicacion", fetch=FetchType.EAGER)
	private List<Podologo> podologos;

	//bi-directional many-to-one association to Presupuesto
	@OneToMany(mappedBy="ubicacionLlegada", fetch=FetchType.EAGER)
	private List<Presupuesto> presupuestos1;

	//bi-directional many-to-one association to Presupuesto
	@OneToMany(mappedBy="ubicacionPartida", fetch=FetchType.EAGER)
	private List<Presupuesto> presupuestos2;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="ubicacion", fetch=FetchType.EAGER)
	private List<Solicitud> solicituds;

	//bi-directional many-to-one association to Comuna
	@ManyToOne
	private Comuna comuna;

	public Ubicacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setUbicacion(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setUbicacion(null);

		return atencion;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setUbicacion(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setUbicacion(null);

		return paciente;
	}

	public List<Podologo> getPodologos() {
		return this.podologos;
	}

	public void setPodologos(List<Podologo> podologos) {
		this.podologos = podologos;
	}

	public Podologo addPodologo(Podologo podologo) {
		getPodologos().add(podologo);
		podologo.setUbicacion(this);

		return podologo;
	}

	public Podologo removePodologo(Podologo podologo) {
		getPodologos().remove(podologo);
		podologo.setUbicacion(null);

		return podologo;
	}

	public List<Presupuesto> getPresupuestos1() {
		return this.presupuestos1;
	}

	public void setPresupuestos1(List<Presupuesto> presupuestos1) {
		this.presupuestos1 = presupuestos1;
	}

	public Presupuesto addPresupuestos1(Presupuesto presupuestos1) {
		getPresupuestos1().add(presupuestos1);
		presupuestos1.setUbicacionLlegada(this);

		return presupuestos1;
	}

	public Presupuesto removePresupuestos1(Presupuesto presupuestos1) {
		getPresupuestos1().remove(presupuestos1);
		presupuestos1.setUbicacionLlegada(null);

		return presupuestos1;
	}

	public List<Presupuesto> getPresupuestos2() {
		return this.presupuestos2;
	}

	public void setPresupuestos2(List<Presupuesto> presupuestos2) {
		this.presupuestos2 = presupuestos2;
	}

	public Presupuesto addPresupuestos2(Presupuesto presupuestos2) {
		getPresupuestos2().add(presupuestos2);
		presupuestos2.setUbicacionPartida(this);

		return presupuestos2;
	}

	public Presupuesto removePresupuestos2(Presupuesto presupuestos2) {
		getPresupuestos2().remove(presupuestos2);
		presupuestos2.setUbicacionPartida(null);

		return presupuestos2;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicituds().add(solicitud);
		solicitud.setUbicacion(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicituds().remove(solicitud);
		solicitud.setUbicacion(null);

		return solicitud;
	}

	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

}