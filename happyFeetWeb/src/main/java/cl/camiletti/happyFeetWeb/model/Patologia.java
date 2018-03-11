package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patologia database table.
 * 
 */
@Entity
@NamedQuery(name="Patologia.findAll", query="SELECT p FROM Patologia p")
public class Patologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String foto;

	private String nombre;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="patologia", fetch=FetchType.EAGER)
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy="patologia", fetch=FetchType.EAGER)
	private List<Solicitudatencion> solicitudatencions;

	//bi-directional many-to-one association to Tratamiento
	@OneToMany(mappedBy="patologia", fetch=FetchType.EAGER)
	private List<Tratamiento> tratamientos;

	public Patologia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
		atencion.setPatologia(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setPatologia(null);

		return atencion;
	}

	public List<Solicitudatencion> getSolicitudatencions() {
		return this.solicitudatencions;
	}

	public void setSolicitudatencions(List<Solicitudatencion> solicitudatencions) {
		this.solicitudatencions = solicitudatencions;
	}

	public Solicitudatencion addSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().add(solicitudatencion);
		solicitudatencion.setPatologia(this);

		return solicitudatencion;
	}

	public Solicitudatencion removeSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().remove(solicitudatencion);
		solicitudatencion.setPatologia(null);

		return solicitudatencion;
	}

	public List<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public Tratamiento addTratamiento(Tratamiento tratamiento) {
		getTratamientos().add(tratamiento);
		tratamiento.setPatologia(this);

		return tratamiento;
	}

	public Tratamiento removeTratamiento(Tratamiento tratamiento) {
		getTratamientos().remove(tratamiento);
		tratamiento.setPatologia(null);

		return tratamiento;
	}

}