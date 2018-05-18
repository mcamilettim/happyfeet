package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@NamedQuery(name="solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellidos;

	private String carnet;

	private String email;

	private String fechaNacimiento;

	private String fono;

	private String idMinSal;

	private String nombres;

	private String rutPodologo;

	private String titulo;

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="paramSexo_id")
	private Parametro paramSexo;

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="paramEstadoSolicitud_id")
	private Parametro paramEstadoSolicitud;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	private Ubicacion ubicacion;

	public Solicitud() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCarnet() {
		return this.carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
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

	public String getFono() {
		return this.fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getIdMinSal() {
		return this.idMinSal;
	}

	public void setIdMinSal(String idMinSal) {
		this.idMinSal = idMinSal;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRutPodologo() {
		return this.rutPodologo;
	}

	public void setRutPodologo(String rutPodologo) {
		this.rutPodologo = rutPodologo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Parametro getParamSexo() {
		return this.paramSexo;
	}

	public void setParamSexo(Parametro paramSexo) {
		this.paramSexo = paramSexo;
	}

	public Parametro getParamEstadoSolicitud() {
		return this.paramEstadoSolicitud;
	}

	public void setParamEstadoSolicitud(Parametro paramEstadoSolicitud) {
		this.paramEstadoSolicitud = paramEstadoSolicitud;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

}