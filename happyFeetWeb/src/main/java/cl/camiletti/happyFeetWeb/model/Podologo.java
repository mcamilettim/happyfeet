package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

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

	public Podologo() {
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


}