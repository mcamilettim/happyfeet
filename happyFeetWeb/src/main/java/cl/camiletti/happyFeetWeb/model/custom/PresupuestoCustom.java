package cl.camiletti.happyFeetWeb.model.custom;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Horario;

public class PresupuestoCustom {
	private String isDiabetico;
	private List<Horario> horarios;
	private String direccion_origen;
	private String direccion_destino;
	private String kilometros;
	private int montoKilometros;
	private int montoPorKilometro;
	private String nombrePodologo;
	private Double evaluacion;
	private String patologia_nombre;
	private int patologia_monto;
	private int total;
	private String rutPodologo;
	private int patologia_id;
	private int descuento;
	private int totalConDescuento;
	
	public int getPatologia_id() {
		return patologia_id;
	}

	public int getTotalConDescuento() {
		return totalConDescuento;
	}

	public void setTotalConDescuento(int totalConDescuento) {
		this.totalConDescuento = totalConDescuento;
	}

	public void setPatologia_id(int patologia_id) {
		this.patologia_id = patologia_id;
	}

	public String getRutPodologo() {
		return rutPodologo;
	}

	public void setRutPodologo(String rutPodologo) {
		this.rutPodologo = rutPodologo;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getIsDiabetico() {
		return isDiabetico;
	}

	public void setIsDiabetico(String isDiabetico) {
		this.isDiabetico = isDiabetico;
	}

	public String getDireccion_origen() {
		return direccion_origen;
	}

	public void setDireccion_origen(String direccion_origen) {
		this.direccion_origen = direccion_origen;
	}

	public String getDireccion_destino() {
		return direccion_destino;
	}

	public void setDireccion_destino(String direccion_destino) {
		this.direccion_destino = direccion_destino;
	}

	public String getKilometros() {
		return kilometros;
	}

	public void setKilometros(String kilometros) {
		this.kilometros = kilometros;
	}

	public int getMontoKilometros() {
		return montoKilometros;
	}

	public void setMontoKilometros(int montoKilometros) {
		this.montoKilometros = montoKilometros;
	}

	public int getMontoPorKilometro() {
		return montoPorKilometro;
	}

	public void setMontoPorKilometro(int montoPorKilometro) {
		this.montoPorKilometro = montoPorKilometro;
	}

	public String getNombrePodologo() {
		return nombrePodologo;
	}

	public void setNombrePodologo(String nombrePodologo) {
		this.nombrePodologo = nombrePodologo;
	}

	public Double getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Double evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getPatologia_nombre() {
		return patologia_nombre;
	}

	public void setPatologia_nombre(String patologia_nombre) {
		this.patologia_nombre = patologia_nombre;
	}

	public int getPatologia_monto() {
		return patologia_monto;
	}

	public void setPatologia_monto(int patologia_monto) {
		this.patologia_monto = patologia_monto;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
