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
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String fecha;

	private String hora;
	
	private String horaFin;

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="paramEstadoHorario_id")
	private Parametro paramEstadoHorario;

	//bi-directional many-to-one association to Podologo
	@ManyToOne
	private Podologo podologo;

	public Horario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Parametro getParamEstadoHorario() {
		return this.paramEstadoHorario;
	}

	public void setParamEstadoHorario(Parametro paramEstadoHorario) {
		this.paramEstadoHorario = paramEstadoHorario;
	}

	public Podologo getPodologo() {
		return this.podologo;
	}

	public void setPodologo(Podologo podologo) {
		this.podologo = podologo;
	}
}