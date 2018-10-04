package conexion_http;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;


import modelo.TareaHttp;

public class JsonToAsignacion {
	
	public static List<TareaHttp> main(ClientResponse response) {
		try {

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			Type tareasType = new TypeToken<List<TareaHttp>>() {}.getType();    
		 	List<TareaHttp> tareas = new Gson().fromJson(output,tareasType);
		 	TareasHttpToTarea pasaje =new TareasHttpToTarea();
		 	tareas.stream().forEach(t -> pasaje.pasarATarea(t));
		 		return tareas;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
}
