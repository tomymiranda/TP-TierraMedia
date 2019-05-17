package excepciones;

public class LecturaArchivoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LecturaArchivoException(String msg){
		super("Error al leer archivo " + msg);
	}
}
