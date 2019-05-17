package excepciones;

public class ArmarListaException extends Exception {
	public ArmarListaException(String archivo){
		super("Error al armar lista del archivo " + archivo);
	}
}
