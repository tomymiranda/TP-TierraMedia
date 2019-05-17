package excepciones;

public class YaNoHayAtraccionesParaOfrecerException extends Exception {

	public YaNoHayAtraccionesParaOfrecerException() {
		super("todas las atracciones ya fueron ofrecidas");
	}

}
