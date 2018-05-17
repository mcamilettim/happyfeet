package cl.camiletti.happyFeetWeb.model.custom;

public class CuestionarioCustom {
	private int id;
	private String nombre;
	private int descuento;
	private String fecha;
	private String tipo;
	
	private int total_cuestionario_podologo_respondido;
	private int total_cuestionario_paciente_respondido;
	private int total_cuestionario_paciente_pendiente;
	private int total_cuestionario_podologo_pendiente;

	private int total_respuesta_uno_si;
	private int total_respuesta_uno_no;
	private int total_respuesta_dos_si;
	private int total_respuesta_dos_no;
	private int total_respuesta_tres_si;
	private int total_respuesta_tres_no;

	private int total_podologo_satisfecho;
	private int total_paciente_satisfecho;

	private int total_podologo_insatisfecho;
	private int total_paciente_insatisfecho;
 
	 
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTotal_podologo_insatisfecho() {
		return total_podologo_insatisfecho;
	}

	public void setTotal_podologo_insatisfecho(int total_podologo_insatisfecho) {
		this.total_podologo_insatisfecho = total_podologo_insatisfecho;
	}

	public int getTotal_paciente_insatisfecho() {
		return total_paciente_insatisfecho;
	}

	public void setTotal_paciente_insatisfecho(int total_paciente_insatisfecho) {
		this.total_paciente_insatisfecho = total_paciente_insatisfecho;
	}
  
	 
	public int getTotal_podologo_satisfecho() {
		return total_podologo_satisfecho;
	}

	public void setTotal_podologo_satisfecho(int total_podologo_satisfecho) {
		this.total_podologo_satisfecho = total_podologo_satisfecho;
	}

	public int getTotal_paciente_satisfecho() {
		return total_paciente_satisfecho;
	}

	public void setTotal_paciente_satisfecho(int total_paciente_satisfecho) {
		this.total_paciente_satisfecho = total_paciente_satisfecho;
	}

	public int getTotal_cuestionario_paciente_pendiente() {
		return total_cuestionario_paciente_pendiente;
	}

	public void setTotal_cuestionario_paciente_pendiente(int total_cuestionario_paciente_pendiente) {
		this.total_cuestionario_paciente_pendiente = total_cuestionario_paciente_pendiente;
	}

	public int getTotal_cuestionario_podologo_pendiente() {
		return total_cuestionario_podologo_pendiente;
	}

	public void setTotal_cuestionario_podologo_pendiente(int total_cuestionario_podologo_pendiente) {
		this.total_cuestionario_podologo_pendiente = total_cuestionario_podologo_pendiente;
	}

	 

	public int getTotal_cuestionario_podologo_respondido() {
		return total_cuestionario_podologo_respondido;
	}

	public void setTotal_cuestionario_podologo_respondido(int total_cuestionario_podologo_respondido) {
		this.total_cuestionario_podologo_respondido = total_cuestionario_podologo_respondido;
	}

	public int getTotal_cuestionario_paciente_respondido() {
		return total_cuestionario_paciente_respondido;
	}

	public void setTotal_cuestionario_paciente_respondido(int total_cuestionario_paciente_respondido) {
		this.total_cuestionario_paciente_respondido = total_cuestionario_paciente_respondido;
	}

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
