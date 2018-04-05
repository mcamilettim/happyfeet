package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the presupuesto database table.
 * 
 */
@Entity
@NamedQuery(name="Presupuesto.findAll", query="SELECT p FROM Presupuesto p")
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int tarifaKM;
	private Double  cantidadKM;
	private int total;

	private int viajePodologo;

	 

	//bi-directional many-to-one association to Detallepresupuesto
	@OneToMany(mappedBy="presupuesto", fetch=FetchType.EAGER)
	private List<Detallepresupuesto> detallepresupuestos;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	@JoinColumn(name="ubicacionLlegada_id")
	private Ubicacion ubicacionLlegada;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	@JoinColumn(name="ubicacionPartida_id")
	private Ubicacion ubicacionPartida;

	//bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy="presupuesto", fetch=FetchType.EAGER)
	private List<Solicitudatencion> solicitudatencions;
	
	//bi-directional many-to-one association to Solicitudatencion
	@OneToMany(mappedBy="presupuesto", fetch=FetchType.EAGER)
	private List<Agenda> agendas;

	public Presupuesto() {
	}

	public int getId() {
		return this.id;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
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

	public List<Solicitudatencion> getSolicitudatencions() {
		return this.solicitudatencions;
	}

	public void setSolicitudatencions(List<Solicitudatencion> solicitudatencions) {
		this.solicitudatencions = solicitudatencions;
	}

	public Solicitudatencion addSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().add(solicitudatencion);
		solicitudatencion.setPresupuesto(this);

		return solicitudatencion;
	}

	public Solicitudatencion removeSolicitudatencion(Solicitudatencion solicitudatencion) {
		getSolicitudatencions().remove(solicitudatencion);
		solicitudatencion.setPresupuesto(null);

		return solicitudatencion;
	}

	public Double getCantidadKM() {
		return cantidadKM;
	}

	public void setCantidadKM(Double cantidadKM) {
		this.cantidadKM = cantidadKM;
	}

}