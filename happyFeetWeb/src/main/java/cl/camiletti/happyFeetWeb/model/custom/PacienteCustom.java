package cl.camiletti.happyFeetWeb.model.custom;

import cl.camiletti.happyFeetWeb.model.Ubicacion;

public class PacienteCustom {
	
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

	private Ubicacion ubicacion;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDiabetico() {
		return diabetico;
	}

	public void setDiabetico(String diabetico) {
		this.diabetico = diabetico;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaUltimaAtencion() {
		return fechaUltimaAtencion;
	}

	public void setFechaUltimaAtencion(String fechaUltimaAtencion) {
		this.fechaUltimaAtencion = fechaUltimaAtencion;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

}
