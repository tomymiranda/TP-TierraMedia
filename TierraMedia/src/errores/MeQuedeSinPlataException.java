package errores;

public class MeQuedeSinPlataException extends Exception {

	public MeQuedeSinPlataException() {
		super("El usuario se quedo sin monedas");
	}
}
