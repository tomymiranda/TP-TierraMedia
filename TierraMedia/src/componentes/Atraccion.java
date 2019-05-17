package componentes;

public class Atraccion implements Comparable<Atraccion> {

	private String nombre;
	private int costo;
	private double tiempoDeDuracion;
	int capacidadRestante;
	TipoDeAtracciones tipo;

	public Atraccion(String nombre, int costo, double tiempoDeDuracion,
			int capacidad, TipoDeAtracciones tipo) {

		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.capacidadRestante = capacidad;
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

	public int getcapacidadRestante() {
		return capacidadRestante;
	}

	public void setcapacidadRestante(int capacidad) {
		this.capacidadRestante = capacidad;
	}
	
	public void setTipo(TipoDeAtracciones tipo) {
		this.tipo = tipo;
	}
	
	public TipoDeAtracciones getTipo() {
		return this.tipo;
	}

	@Override
	public String toString() {
		return this.getNombre() + " | "  + this.getCosto() + " | "  + this.getTiempoDeDuracion()  + " | "  + this.getcapacidadRestante()  + " | "  + this.getTipo();
	}

	@Override
	public int compareTo(Atraccion atraccion) {
		if(this.tipo == atraccion.tipo) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
