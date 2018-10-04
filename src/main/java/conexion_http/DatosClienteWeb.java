package conexion_http;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

import modelo.TareaHttp;

public class DatosClienteWeb {

	public static void main(String args[]) {
		Cliente cliente = new Cliente();
		System.out.println(cliente.getEstudiante().getEntity(String.class));
		System.out.println(cliente.getAsignaciones().getEntity(String.class));
	}
	
	/*public static void main(String args[]) {
		Cliente cliente = new Cliente();
		
		try {
			ClientResponse response = cliente.putEstudiante(EstudianteToJson.pasarAJson(111222333, "Lisa", "Simpsons", "Growler"));
			if (response.getStatus() != 200) {
				System.out.println(response.toString());
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}*/
	
}


