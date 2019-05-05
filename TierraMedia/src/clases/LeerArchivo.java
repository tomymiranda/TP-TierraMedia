package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeerArchivo {
	/*
	 * PRE: Path: Ruta completa EJ: C:\\Users\\[userName]\\Desktop\\tierraMedia.txt
	 */
	public ArrayList<String> obtenerDatos(String path) throws Exception {
		ArrayList<String> lines = new ArrayList<String>();
		if(path.length() != 0) {
			try {
				FileReader file = new FileReader(path);
				BufferedReader reader = new BufferedReader(file);
				String line;
				while((line = reader.readLine()) != null) {
					lines.add(line);
				}
				reader.close();
				return lines;
			}
			catch(Exception e){
				throw new Error(e.getMessage());
			}
		} else {
			throw new Exception("Ruta invalida");
		}
		
	}

}
