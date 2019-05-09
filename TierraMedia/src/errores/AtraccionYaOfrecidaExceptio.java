package errores;

public class AtraccionYaOfrecidaExceptio extends Exception {

	public AtraccionYaOfrecidaExceptio() {
		super("Ya atraccion ya fue ofrecida");
	}
}
