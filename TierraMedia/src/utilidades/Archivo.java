package utilidades;
import java.io.*;
import java.util.*;
import clases.*;

public class Archivo {
	
	static final String EXTENSION = ".txt";
	static final String CARPETA = "archivos";
	static final String RAIZ = "src";
	static final String SEPARADOR = ",";
	File archivo = null;
    static FileReader fileReader = null;
    static BufferedReader bufferReader = null;
    static String linea = "";
    	
	public static List Leer( String path) throws Exception {
		
		String ruta = RutaActual()+File.separator+RAIZ+File.separator+File.separator+CARPETA+File.separator+path+EXTENSION;
		try{			
			File archivo = new File (ruta);
			FileReader fileReader = new FileReader (archivo);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			
			switch(path) {
				case "Atracciones":
					List listaAtracciones = new ArrayList<Atraccion>();
					
					while ((linea = bufferReader.readLine()) != null) {
						String[] datos = linea.split(SEPARADOR);
						listaAtracciones.add(crearAtraccion(datos));
					}
					
					return listaAtracciones;
					
				case "Usuarios":
					List listaUsuarios = new ArrayList<Usuario>();
					
					while ((linea = bufferReader.readLine()) != null) {
						String[] datos = linea.split(SEPARADOR);
						listaUsuarios.add(crearUsuario(datos));
						
					}
					return listaUsuarios;
				default:
					return new ArrayList<Promocion>();
			}
			
				
		}catch(Exception e) {
		     throw new Exception(e.getMessage());
		}

	
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
	
	  private static Atraccion crearAtraccion(String[] datos) {
		  
		  switch(datos[3]) {
			 case "Aventura":
				 return new Atraccion(datos[0],
				    		Integer.parseInt(datos[1]),
				    		Double.parseDouble(datos[2]),
				    		Integer.parseInt(datos[3]),
				    		TipoDeAtracciones.Aventura);
			 case "Degustacion":
				 return new Atraccion(datos[0],
				    		Integer.parseInt(datos[1]),
				    		Double.parseDouble(datos[2]),
				    		Integer.parseInt(datos[3]),
				    		TipoDeAtracciones.Desgustacion);
			 default:
				 return new Atraccion(datos[0],
				    		Integer.parseInt(datos[1]),
				    		Double.parseDouble(datos[2]),
				    		Integer.parseInt(datos[3]),
				    		TipoDeAtracciones.Paisaje);
		 }
		  
	  }
	  
	  private static Usuario crearUsuario(String[] datos) {
		  switch(datos[3]) {
			 case "Aventura":
				 return new Usuario(
							datos[0],
							Integer.parseInt(datos[1]),
							Double.parseDouble(datos[2]),
							TipoDeAtracciones.Aventura
						);
			 case "Degustacion":
				 return new Usuario(
							datos[0],
							Integer.parseInt(datos[1]),
							Double.parseDouble(datos[2]),
							TipoDeAtracciones.Desgustacion
						);
			 default:
				 return new Usuario(
							datos[0],
							Integer.parseInt(datos[1]),
							Double.parseDouble(datos[2]),
							TipoDeAtracciones.Paisaje
						);
		 }
		  
	  }
}
