package excepciones;

public class EscribirArchivoException extends Exception {
	public EscribirArchivoException(String archivo){
		super("Error al escribir el archivo " + archivo);
	}
}
