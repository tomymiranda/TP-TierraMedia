package utilidades;

import java.io.*;
import java.util.*;

import componentes.*;
import excepciones.*;
import promociones.Absoluta;
import promociones.AxB;
import promociones.Porcentual;

public class Archivo {

	final String SEPARADOR = ",";
	File archivo = null;
	BufferedReader bufferReader = null;
	String linea = "";
	FileWriter fileWriter = null;
	BufferedWriter bufferWriter = null;
	Visualizador view = new Visualizador();

	// Lectura de Archivos

	public List<Usuario> LeerUsuarios(String archivo) throws Exception {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		bufferReader = getBufferReader(archivo);

		try {
			while ((linea = bufferReader.readLine()) != null) {
				String[] datos = linea.split(SEPARADOR);
				listaUsuarios.add(crearUsuario(datos));

			}

			return listaUsuarios;
		} catch (IOException e) {
			throw new ArmarListaException(archivo);
		} finally {
			cerrarBufferedReader(bufferReader, archivo);
		}

	}

	public List<Atraccion> LeerAtracciones(String archivo) throws Exception {

		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		bufferReader = getBufferReader(archivo);

		try {
			while ((linea = bufferReader.readLine()) != null) {
				String[] datos = linea.split(SEPARADOR);
				listaAtracciones.add(crearAtraccion(datos));

			}

			return listaAtracciones;
		} catch (IOException e) {
			throw new ArmarListaException(archivo);
		} finally {
			cerrarBufferedReader(bufferReader, archivo);
		}

	}

	public List<Promocion> LeerPromociones(String archivo, List<Atraccion> listaAtracciones) throws Exception {

		List<Promocion> listaPromociones = new ArrayList<Promocion>();
		List<Atraccion> atracciones = null;
		bufferReader = getBufferReader(archivo);

		try {
			while ((linea = bufferReader.readLine()) != null) {
				String[] datos = linea.split(";");

				atracciones = new ArrayList<Atraccion>();

				for (String atr : datos[1].split(SEPARADOR)) {
					atracciones.add(listaAtracciones.get(obtenerIndice(atr, listaAtracciones) - 1));
				}

				listaPromociones.add(crearPromocion(datos[0], atracciones, datos[2], datos[3], datos[4]));

			}

			return listaPromociones;
		} catch (IOException e) {
			throw new ArmarListaException(archivo);
		} finally {
			cerrarBufferedReader(bufferReader, archivo);
		}

	}

	// Crear

	private Atraccion crearAtraccion(String[] datos) {

		switch (datos[4]) {
		case "Aventura":
			return new Atraccion(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
					Integer.parseInt(datos[3]), TipoDeAtracciones.Aventura);
		case "Degustacion":
			return new Atraccion(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
					Integer.parseInt(datos[3]), TipoDeAtracciones.Desgustacion);
		default:
			return new Atraccion(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
					Integer.parseInt(datos[3]), TipoDeAtracciones.Paisaje);
		}

	}

	private Usuario crearUsuario(String[] datos) {
		switch (datos[3]) {
		case "Aventura":
			return new Usuario(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
					TipoDeAtracciones.Aventura);
		case "Degustacion":
			return new Usuario(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
					TipoDeAtracciones.Desgustacion);
		default:
			return new Usuario(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
					TipoDeAtracciones.Paisaje);
		}

	}

	private <T> Promocion crearPromocion(String nombre, List<Atraccion> atracciones, String tipo, T datoExtra,
			String descripcion) {

		switch (tipo) {
		case "Porcentual":
			return new Porcentual(nombre, atracciones, Integer.parseInt((String) datoExtra), descripcion);
		case "Absoluta":
			return new Absoluta(nombre, atracciones, Integer.parseInt((String) datoExtra), descripcion);
		case "AxB":
			return new AxB(nombre, atracciones, (String) datoExtra, descripcion);
		default:
			return null;
		}
	}

	// Utils

	public String RutaActual() {
		String ruta = "";
		File directorio = new File(".");
		try {
			ruta = directorio.getCanonicalPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ruta;
	}

	public void guardar(List<String> datos) throws Exception {

		String ruta = RutaActual() + "/src/archivos/itinerario.txt";
		view.log("Guardando... ");
		try {
			fileWriter = new FileWriter(ruta, false);
			bufferWriter = new BufferedWriter(fileWriter);

			for (String dato : datos) {
				bufferWriter.write(dato);
			}
		} catch (Exception e) {
			throw new EscribirArchivoException("itinerario");
		} finally {
			try {
				if (bufferWriter != null)
					bufferWriter.close();
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException ex) {
				System.err.println("Error al cerrar BufferWriter y/o FileWriter en metodo guardar");
			}
		}
	}

	public void generarItinerarios(List<Usuario> listaUsuarios) throws Exception {
		view.log("Generando...");
		List<String> itinerarios = new ArrayList<String>();
		String linea = "";
		for (Usuario user : listaUsuarios) {
			linea = "";
			linea += "----------------------------------------------------------\n";
			linea += "Itinerario para: " + user.getNombre() + "\n";
			linea += view.generarItinerarioPorUsuario(user);
			itinerarios.add(linea);
		}

		guardar(itinerarios);

	}

	private int obtenerIndice(String dato, List<Atraccion> lista) {

		ListIterator<Atraccion> itr = lista.listIterator();

		while (itr.hasNext()) {
			if (itr.next().getNombre().equals(dato))
				return itr.nextIndex();
		}
		;

		return -1;

	}

	// BufferedReader Utils

	private BufferedReader getBufferReader(String nombreArchivo) throws Exception {
		String ruta = RutaActual() + "/src/archivos/" + nombreArchivo.toLowerCase() + ".txt";
		try {
			File archivo = new File(ruta);
			FileReader fileReader = new FileReader(archivo);
			return new BufferedReader(fileReader);
		} catch (Exception e) {
			throw new LecturaArchivoException(nombreArchivo);
		}

	}

	private void cerrarBufferedReader(BufferedReader buffered, String archivo) throws Exception {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException e) {
			// Exception que no se pudo cerrar el reader
			throw new CerrarReaderException(archivo);
		}
	}
}
