package cl.camiletti.happyFeetWeb.model.custom;

import java.util.ArrayList;
import java.util.List;

 
import cl.camiletti.happyFeetWeb.model.Ubicacion;

public class PodologoCustom {
	private String rut;

	private String apellidos;

	private String email;

	private String fono;

	private String foto;

	private String nombres;

	private Ubicacion ubicacion;

	private double evaluacion;
	
	private int cantidadAtenciones;

	private List<HorarioCustom> horarios;

	
	
	
	public PodologoCustom() {
		super();
		this.horarios=new ArrayList<HorarioCustom>();
	}

	public int getCantidadAtenciones() {
		return cantidadAtenciones;
	}

	public void setCantidadAtenciones(int cantidadAtenciones) {
		this.cantidadAtenciones = cantidadAtenciones;
	}

	public List<HorarioCustom> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioCustom> horarios) {
		this.horarios = horarios;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(double evaluacion) {
		this.evaluacion = evaluacion;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
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

}
