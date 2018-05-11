package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the patologia database table.
 * 
 */
@Entity
@NamedQuery(name = "Cuestionario.findAll", query = "SELECT c FROM Cuestionario c")
public class Cuestionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String titulo;
	private String fecha;
	private int descuento;

	private String detalle;

	@ManyToOne
	private Preguntas preguntas;

	private String tipo;

	public int getId() {
		return id;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Preguntas getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

 
	 
}