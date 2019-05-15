package utilidades;
import java.io.*;
import java.util.*;
import componentes.*;
import promociones.Porcentual;

public class Archivo {
	
	final String EXTENSION = ".txt";
	final String CARPETA = "archivos";
	final String RAIZ = "src";
	final String SEPARADOR = ",";
	File archivo = null;
    FileReader fileReader = null;
    BufferedReader bufferReader = null;
    String linea = "";
    FileWriter fileWriter = null;
	BufferedWriter bufferWriter = null;
	Visualizador view = new Visualizador();
    	
	public List<Usuario> LeerUsuarios(String path) {
		
		String ruta = RutaActual()+File.separator+RAIZ+File.separator+CARPETA+File.separator+path.toLowerCase()+EXTENSION;
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			
		try {
			File archivo = new File (ruta);
			FileReader fileReader;
			fileReader = new FileReader (archivo);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			while ((linea = bufferReader.readLine()) != null) {
				String[] datos = linea.split(SEPARADOR);
				listaUsuarios.add(crearUsuario(datos));
				
			}
			
		} catch ( IOException e) {
			//Exception problema al leer el archivo
			e.printStackTrace();
		}
		finally {
			try {
				if(bufferReader != null)
					bufferReader.close();								
			}
			catch(IOException e) {
				//Exception que no se pudo cerra el reader
				e.printStackTrace();
			}
		}
	
		return listaUsuarios;
	}
	
public List<Atraccion> LeerAtracciones(String path) {
		
		String ruta = RutaActual()+File.separator+RAIZ+File.separator+CARPETA+File.separator+path.toLowerCase()+EXTENSION;
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
			
		try {
			File archivo = new File (ruta);
			FileReader fileReader;
			fileReader = new FileReader (archivo);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			while ((linea = bufferReader.readLine()) != null) {
				String[] datos = linea.split(SEPARADOR);
				listaAtracciones.add(crearAtraccion(datos));
				
			}
			
		} catch ( IOException e) {
			//Exception problema al leer el archivo
			e.printStackTrace();
		}
		finally {
			try {
				if(bufferReader != null)
					bufferReader.close();								
			}
			catch(IOException e) {
				//Exception que no se pudo cerra el reader
				e.printStackTrace();
			}
		}
	
		return listaAtracciones;
	}
	
public  String RutaActual () {
	  	String ruta = "";
	     File directorio = new File (".");
	     try {
	    	 ruta = directorio.getCanonicalPath();
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
		return ruta;
	  }
	  
	public void guardar( List<String> datos ){
		  
			String ruta = RutaActual()+File.separator+RAIZ+File.separator+CARPETA+File.separator+"itinerario"+EXTENSION;
			view.log("Guardando... ");
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
	  
	public void generarItinerarios(List<Usuario> listaUsuarios) {
		  view.log("Generando...");
		  List<String> itinerarios = new ArrayList<String>();
		  String linea = "";
		  for(Usuario user : listaUsuarios) {
			  	linea = "";
				linea += "----------------------------------------------------------\n";
				linea += "Itinerario para: " + user.getNombre() + "\n";
				linea += view.generarItinerarioPorUsuario(user);
				itinerarios.add(linea);		
		  }
		  
		  guardar(itinerarios);
		  
	  }
	
	private Atraccion crearAtraccion(String[] datos) {
		  
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
	  
	private Usuario crearUsuario(String[] datos) {
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
	
	public List<Promocion> LeerPromociones(String path, List<Atraccion> listaAtracciones) {

		String ruta = RutaActual() + File.separator + RAIZ + File.separator + CARPETA + File.separator
				+ path.toLowerCase() + EXTENSION;
		List<Promocion> listaPromociones = new ArrayList<Promocion>();
		List<Atraccion> atracciones = null;
		try {
			//Metodo general
			File archivo = new File(ruta);
			FileReader fileReader;
			fileReader = new FileReader(archivo);
			BufferedReader bufferReader = new BufferedReader(fileReader);

			while ((linea = bufferReader.readLine()) != null) {
				String[] datos = linea.split(";");
				atracciones = new ArrayList<Atraccion>();

				for(String atr : datos[1].split(SEPARADOR)) {
					atracciones.add(listaAtracciones.get(obtenerIndice(atr, listaAtracciones)-1));
				}	
				
				listaPromociones.add(crearPromocion(datos[0],atracciones, datos[2], datos[3]));

			}
			
			//
		} catch (IOException e) {
			// Exception problema al leer el archivo
			e.printStackTrace();
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException e) {
				// Exception que no se pudo cerrar el reader
				e.printStackTrace();
			}
		}

		return listaPromociones;
	}
	
	private Promocion crearPromocion(String nombre, List<Atraccion> atracciones, String tipo, String descripcion) {
		
			switch (tipo) {
				case "Porcentual":
					return new Porcentual(nombre, atracciones, descripcion);
				default: 
					return null;
			}
	}
	
	private int obtenerIndice(String dato, List<Atraccion> lista) {
		
		ListIterator<Atraccion> itr = lista.listIterator(0);
		
		while(itr.hasNext()) {
			if(itr.next().getNombre().equals(dato)) {
				return itr.nextIndex();				
			}
		};
		
		return -1;
		
	}
}
