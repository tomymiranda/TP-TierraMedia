package clases;

public class Atraccion {

	private String nombre;
	private int costo;
	private double tiempoDeDuracion;
	int capacidad;
	TipoDeAtracciones tipo;

	public Atraccion(String nombre, int costo, double tiempoDeDuracion,
			int capacidad, TipoDeAtracciones tipo) {

		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.capacidad = capacidad;
		this.tipo = tipo;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public double getTiempoDeDuracion() {
		return tiempoDeDuracion;
	}

	public void setTiempoDeDuracion(double tiempoDeDuracion) {
		this.tiempoDeDuracion = tiempoDeDuracion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void setTipo(TipoDeAtracciones tipo) {
		this.tipo = tipo;
	}
	
	public TipoDeAtracciones getTipo() {
		return this.tipo;
	}

}
