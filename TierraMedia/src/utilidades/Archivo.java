package utilidades;
import java.io.*;
import java.util.*;
import componentes.*;

public class Archivo {
	
	static final String EXTENSION = ".txt";
	static final String CARPETA = "archivos";
	static final String RAIZ = "src";
	static final String SEPARADOR = ",";
	File archivo = null;
    static FileReader fileReader = null;
    static BufferedReader bufferReader = null;
    static String linea = "";
    private static FileWriter fileWriter = null;
	private static BufferedWriter bufferWriter = null;
    	
	public static List Leer( String path) throws Exception {
		
		String ruta = RutaActual()+File.separator+RAIZ+File.separator+File.separator+CARPETA+File.separator+path.toLowerCase()+EXTENSION;
		try{			
			File archivo = new File (ruta);
			FileReader fileReader = new FileReader (archivo);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			
			switch(path.toUpperCase()) {
				case "ATRACCIONES":
					List listaAtracciones = new ArrayList<Atraccion>();
					
					while ((linea = bufferReader.readLine()) != null) {
						String[] datos = linea.split(SEPARADOR);
						listaAtracciones.add(crearAtraccion(datos));
					}
					
					return listaAtracciones;
					
				case "USUARIOS":
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
	  
	  
	  public static void guardar ( List<String> datos ){
		  
			String ruta = RutaActual()+File.separator+RAIZ+File.separator+CARPETA+File.separator+"itinerario"+EXTENSION;
			Visualizador.log("Guardando... ");
			try{	
				fileWriter = new FileWriter(ruta, false);
				bufferWriter =  new BufferedWriter(fileWriter);
			
				for(String dato : datos) {
					bufferWriter.write(dato);					
				}
				
				
			}catch(Exception e) {
				System.err.format("IOException: %s%n", e);
		    } finally {
	            try {
	                if (bufferWriter != null)
	                    bufferWriter.close();
	                if(fileWriter != null)
	                	fileWriter.close();
	            } catch (IOException ex) {
	                System.err.format("IOException: %s%n", ex);
	            }
	        }

	  }
	  
	  public static void generarItinerarios(List<Usuario> listaUsuarios) {
		  Visualizador.log("Generando...");
		  List<String> itinerarios = new ArrayList<String>();
		  String linea = "";
		  for(Usuario user : listaUsuarios) {
			  	linea = "";
				linea += "----------------------------------------------------------\n";
				linea += "Itinerario para: " + user.getNombre() + "\n";
				linea += Visualizador.generarItinerarioPorUsuario(user);
				itinerarios.add(linea);		
		  }
		  
		  guardar(itinerarios);
		  
	  }
	
	  private static Atraccion crearAtraccion(String[] datos) {
		  
		  switch(datos[4]) {
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
