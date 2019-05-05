package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		LeerArchivo reader = new LeerArchivo();
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		String unaLinea = in.readLine();
		
		System.out.println("Path: " +unaLinea);
		
		ArrayList<String> result = reader.obtenerDatos(unaLinea);
		
		System.out.println(result);
	}
}