package conexion_http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class jsonGenerico<T> {
	
	private String file; // El archivo con el .json
	private BufferedWriter escritorBuffer; // objeto que nos va a permitir poder escribir en el json 
	private final Gson gson = new Gson(); // creo la instancia de Gson para manejar json
	private List<T> listaDatos = new ArrayList<>(); // la lista en donde vamos a guardar los datos del json
	public jsonGenerico(String file) {
		this.file = file; // el archivo json con los datos
	}

	// transformo mi archivo .json en un String
	private String jsonToString() throws IOException {
		
		FileReader ficheroModoLectura = new	FileReader(file); // para poder leer un fichero, en nuestro caso el .json
		BufferedReader lector = new BufferedReader(ficheroModoLectura); // Leo el archivo .json
		String linea = null; // lo voy a usar para leer linea por linea del json
		StringBuilder stringBuilder = new StringBuilder(0); // para poder manejar el string
		String saltoDeLinea = System.getProperty("line.separator"); // esto viene hacer el /n en c
		while ( (linea = lector.readLine()) != null) { // leo cada linea del json
			stringBuilder.append(linea); // copio la linea del json a mi stringBuilder
			stringBuilder.append(saltoDeLinea);// hago un salto de linea
		}
		lector.close(); // cierro el flujo y libero los recursos
		return stringBuilder.toString();// transformo mi stringBuilder en un string
	}
	
	// transformo el String con los datos del json en una lista de datos clase T y la retorno	
	public List<T> getListaClientes(Class<T[]> clazz) throws JsonSyntaxException, IOException {
	    T[] arr = gson.fromJson(this.jsonToString(), clazz);
	    listaDatos.addAll(Arrays.asList(arr));
	    return listaDatos;
	}
	
	private void listaDatosToJson() throws IOException {
		
		FileWriter ficheroModoEscritura = new FileWriter(file); // para poder escribir en un fichero
		
		String datosString = gson.toJson(listaDatos); //Transformo la lista de instancias de clase T en un String
		
		escritorBuffer = new BufferedWriter(ficheroModoEscritura); //abro el archivo para poder escribir
		escritorBuffer.write(datosString); // escribo en "file" los datos de la lista clase T (previamente tranformados en un string)
		escritorBuffer.close(); // cierro el flujo y libero los recursos
		
	}
	
	// me permite agregar un cliente nuevo en mi archivo json
	public void agregarUnCliente(T unDato) throws IOException {
		
		listaDatos.add(unDato); // agrego un Dato T a la lista
		
		this.listaDatosToJson();
	}
	
	public void borrarDatoT(T unDato) throws IOException {

		listaDatos.remove(unDato);
		this.listaDatosToJson();
	}
}
