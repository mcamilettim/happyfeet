package cl.camiletti.happyFeetWeb.model.custom;

public class DescuentoCustom {
	private int id;
	private String nombre;
	private int descuento;

	public DescuentoCustom(int id, String nombre, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descuento = descuento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
