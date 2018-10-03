package conexion_http;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import modelo.Estudiante;

public class JsonToEstudiante {

	public static Estudiante main(ClientResponse response) {
		try {

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
			
		 	Estudiante est = new Gson().fromJson(output,Estudiante.class);
		 	
		 		return est;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
	
}