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
			String json = output.substring(0, output.length() - 1).substring(15);
			//System.out.println(json);
			List<TareaHttp> tareas = new ArrayList<TareaHttp>();
			TareaHttp[] tar = new Gson().fromJson(json, TareaHttp[].class);
			
			tareas.addAll(Arrays.asList(tar));
			
		 		return tareas;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static TareaHttp[] tareas(ClientResponse response) {
		String output = response.getEntity(String.class);
		List<TareaHttp> tareas = new ArrayList<TareaHttp>();
		TareaHttp[] tar = new Gson().fromJson(output, TareaHttp[].class);
		return tar;
	}
}
