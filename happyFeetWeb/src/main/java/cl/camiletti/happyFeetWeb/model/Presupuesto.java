package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the presupuesto database table.
 * 
 */
@Entity
@NamedQuery(name = "presupuesto.findAll", query = "SELECT p FROM Presupuesto p")
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int tarifaKM;
	private Double cantidadKM;
	private int total;
	private int subtotal;
	private int viajePodologo;
	private int montoDescuento;
	// bi-directional many-to-one association to Detallepresupuesto
	@OneToMany(mappedBy = "presupuesto", fetch = FetchType.EAGER)
	private List<Detallepresupuesto> detallepresupuestos;

	@ManyToOne
	@JoinColumn(name = "cuestionariopaciente_id")
	private Cuestionariopaciente cuestionarioPaciente;
	// bi-directional many-to-one association to Ubicacion
	@ManyToOne
	@JoinColumn(name = "ubicacionLlegada_id")
	private Ubicacion ubicacionLlegada;

	// bi-directional many-to-one association to Ubicacion
	@ManyToOne
	@JoinColumn(name = "ubicacionPartida_id")
	private Ubicacion ubicacionPartida;
 

	public Presupuesto() {
	}

	public Cuestionariopaciente getCuestionarioPaciente() {
		return cuestionarioPaciente;
	}

	public void setCuestionarioPaciente(Cuestionariopaciente cuestionarioPaciente) {
		this.cuestionarioPaciente = cuestionarioPaciente;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public int getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(int montoDescuento) {
		this.montoDescuento = montoDescuento;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getId() {
		return this.id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public int getTarifaKM() {
		return this.tarifaKM;
	}

	public void setTarifaKM(int tarifaKM) {
		this.tarifaKM = tarifaKM;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getViajePodologo() {
		return this.viajePodologo;
	}

	public void setViajePodologo(int viajePodologo) {
		this.viajePodologo = viajePodologo;
	}

	public List<Detallepresupuesto> getDetallepresupuestos() {
		return this.detallepresupuestos;
	}

	public void setDetallepresupuestos(List<Detallepresupuesto> detallepresupuestos) {
		this.detallepresupuestos = detallepresupuestos;
	}

	public Detallepresupuesto addDetallepresupuesto(Detallepresupuesto detallepresupuesto) {
		getDetallepresupuestos().add(detallepresupuesto);
		detallepresupuesto.setPresupuesto(this);

		return detallepresupuesto;
	}

	public Detallepresupuesto removeDetallepresupuesto(Detallepresupuesto detallepresupuesto) {
		getDetallepresupuestos().remove(detallepresupuesto);
		detallepresupuesto.setPresupuesto(null);

		return detallepresupuesto;
	}

	public Ubicacion getUbicacionLlegada() {
		return this.ubicacionLlegada;
	}

	public void setUbicacionLlegada(Ubicacion ubicacionLlegada) {
		this.ubicacionLlegada = ubicacionLlegada;
	}

	public Ubicacion getUbicacionPartida() {
		return this.ubicacionPartida;
	}

	public void setUbicacionPartida(Ubicacion ubicacionPartida) {
		this.ubicacionPartida = ubicacionPartida;
	}
 
 
	public Double getCantidadKM() {
		return cantidadKM;
	}

	public void setCantidadKM(Double cantidadKM) {
		this.cantidadKM = cantidadKM;
	}

}