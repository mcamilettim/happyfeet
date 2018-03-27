package cl.camiletti.happyFeetWeb.model.custom;

public class HorarioCustom {
	private int id;
	private String fecha;
	private String hora;
	private String horaFin;
	private String podologo_rut;
	private int idEstado;
	public HorarioCustom(int id, String fecha, String hora, String horaFin, String podologo_rut, int idEstado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.horaFin = horaFin;
		this.podologo_rut = podologo_rut;
		this.idEstado = idEstado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getPodologo_rut() {
		return podologo_rut;
	}
	public void setPodologo_rut(String podologo_rut) {
		this.podologo_rut = podologo_rut;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
 
	
}
