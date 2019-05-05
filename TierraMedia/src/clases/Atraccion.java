package Clases;

abstract class Atraccion {

	private String nombre;
	private int costo;
	private double tiempoDeDuracion;
	int capacidad;

	public Atraccion(String nombre, int costo, double tiempoDeDuracion,
			int capacidad) {

		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.capacidad = capacidad;

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

}
