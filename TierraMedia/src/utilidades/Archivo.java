package utilidades;
import java.io.*;
import java.util.*;

public class Archivo {
	
	static final String EXTENSION = ".txt";
	static final String CARPETA = "archivos";
	static final String RAIZ = "src";
	static final String SEPARADOR = ",";
	File archivo = null;
    static FileReader fileReader = null;
    static BufferedReader bufferReader = null;
    static String linea = "";
    static String[][] contenido;
	
	public static String[][] Leer( String path) {
		
		String ruta = RutaActual()+File.separator+RAIZ+File.separator+File.separator+CARPETA+File.separator+path+EXTENSION;
		try{			
			File archivo = new File (ruta);
			FileReader fileReader = new FileReader (archivo);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			bufferReader.mark(100000);
			int lineas = (int) bufferReader.lines().count();
			bufferReader.reset();
			int registros = bufferReader.readLine().split(SEPARADOR).length;
			bufferReader.reset();
			contenido = new String[lineas][registros];
			int contador = 0;
			while ((linea = bufferReader.readLine()) != null) { 
			        String[] datos = linea.split(SEPARADOR);
			        for(int i = 0; i < registros; i++){
			        	contenido[contador][i] = datos[i];
			        }
			        contador++; 
			}
				
		}catch(Exception e) {
		      e.printStackTrace();
		}
	
		return contenido;
	
	}
	
	  public static String RutaActual () {
		  	String ruta = "";
		     File directorio = new File (".");
		     try {
		    	 ruta = directorio.getCanonicalPath();
		       }catch(Exception e) {
		    	   e.printStackTrace();
		       }
			return ruta;
		  }
	  
	  
	  public static void guardar ( String[] datos ){
		  
			String ruta = RutaActual()+File.separator+RAIZ+File.separator+File.separator+CARPETA+File.separator+"itinerario"+EXTENSION;
			try{	
				File archivo = new File (ruta);
				FileReader fileReader = new FileReader (archivo);
				BufferedWriter  bufferWrite =  new BufferedWriter(new FileWriter(archivo));
				String nuevaLinea = "";
				for (int i = 0; i < datos.length; i++) {
					nuevaLinea = datos[i]+",";
				}
				bufferWrite.write(nuevaLinea);
				
			}catch(Exception e) {
				e.printStackTrace();
		    }

	  }
	
	
}
