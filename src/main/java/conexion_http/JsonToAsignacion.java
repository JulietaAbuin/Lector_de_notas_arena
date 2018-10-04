package conexion_http;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
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
		System.out.println(output);
			List<TareaHttp> tareas = new ArrayList<TareaHttp>();
			TareaHttp[] tar = new Gson().fromJson(output, TareaHttp[].class);
			tareas.addAll(Arrays.asList(tar));
			
		 		return tareas;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
}
