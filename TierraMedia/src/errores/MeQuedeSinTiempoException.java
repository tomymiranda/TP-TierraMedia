package errores;

public class MeQuedeSinTiempoException extends Exception {
	public MeQuedeSinTiempoException() {
		super("el usuario se ha quedado sin tiempoo");
	}
}
