package Clases;
public class Usuario {

	private String nombre;
	private int cantidadDeMonedas;
	private double tiempoDisponible;
	// private tipoDeAtraccion tipoDeAtraacionPredilecta;

	public Usuario(String nombre, int cantidadDeMonedas, double tiempoDisponible) {

		this.nombre = nombre;
		this.cantidadDeMonedas = cantidadDeMonedas;
		this.tiempoDisponible = tiempoDisponible;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadDeMonedas() {
		return cantidadDeMonedas;
	}

	public void setCantidadDeMonedas(int cantidadDeMonedas) {
		this.cantidadDeMonedas = cantidadDeMonedas;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public void obtenerInfoDeUsuarios() {
		System.out.print("nombre:" + " " + nombre + ",tiene" + " "
				+ cantidadDeMonedas + "disponibles y tiene" + " "
				+ tiempoDisponible
				+ " de tiempo disponible para realizar actividades");
	}

}
