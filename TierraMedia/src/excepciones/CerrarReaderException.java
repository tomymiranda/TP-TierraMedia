package excepciones;

public class CerrarReaderException extends Exception{
	public CerrarReaderException(String archivo){
		super("Error al cerrar el BufferedReader de " + archivo);
	}
}
