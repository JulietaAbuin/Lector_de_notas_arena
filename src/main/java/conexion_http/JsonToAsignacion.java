package conexion_http;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;


import modelo.TareaHttp;
import modelo.TareaServer;
import scala.Console;

public class JsonToAsignacion {
	public static List<TareaServer> main(ClientResponse response) {
		try {
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			Type tareasType = new TypeToken<List<TareaServer>>() {}.getType();    
		 	List<TareaServer> tareas = new Gson().fromJson(output,tareasType);
		 	Console.println(tareas);	
		 	return tareas;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
