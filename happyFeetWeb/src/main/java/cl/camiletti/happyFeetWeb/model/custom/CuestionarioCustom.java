package cl.camiletti.happyFeetWeb.model.custom;

public class CuestionarioCustom {
	private int id;
	private String nombre;
	private int descuento;
	private String fecha;
	private int total_respuesta_uno_si;
	private int total_respuesta_uno_no;
	private int total_respuesta_dos_si;
	private int total_respuesta_dos_no;
	private int total_respuesta_tres_si;
	private int total_respuesta_tres_no;

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public int getTotal_respuesta_uno_si() {
		return total_respuesta_uno_si;
	}

	public void setTotal_respuesta_uno_si(int total_respuesta_uno_si) {
		this.total_respuesta_uno_si = total_respuesta_uno_si;
	}

	public int getTotal_respuesta_uno_no() {
		return total_respuesta_uno_no;
	}

	public void setTotal_respuesta_uno_no(int total_respuesta_uno_no) {
		this.total_respuesta_uno_no = total_respuesta_uno_no;
	}

	public int getTotal_respuesta_dos_si() {
		return total_respuesta_dos_si;
	}

	public void setTotal_respuesta_dos_si(int total_respuesta_dos_si) {
		this.total_respuesta_dos_si = total_respuesta_dos_si;
	}

	public int getTotal_respuesta_dos_no() {
		return total_respuesta_dos_no;
	}

	public void setTotal_respuesta_dos_no(int total_respuesta_dos_no) {
		this.total_respuesta_dos_no = total_respuesta_dos_no;
	}

	public int getTotal_respuesta_tres_si() {
		return total_respuesta_tres_si;
	}

	public void setTotal_respuesta_tres_si(int total_respuesta_tres_si) {
		this.total_respuesta_tres_si = total_respuesta_tres_si;
	}

	public int getTotal_respuesta_tres_no() {
		return total_respuesta_tres_no;
	}

	public void setTotal_respuesta_tres_no(int total_respuesta_tres_no) {
		this.total_respuesta_tres_no = total_respuesta_tres_no;
	}

	public void setId(int id) {
		this.id = id;
	}

}
