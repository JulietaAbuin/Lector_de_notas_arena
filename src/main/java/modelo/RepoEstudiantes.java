package modelo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import conexion_http.JerseyClienteGet;


public class RepoEstudiantes {
	private List<Estudiante> estudiantes = new ArrayList<>();
	private static RepoEstudiantes repo;
	
	public static RepoEstudiantes getInstance() {
		if(repo == null) {
			repo = new RepoEstudiantes();
		}
		return repo;
	}
	
	public void agregar(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
	}

	public List<Estudiante> all() {
		return estudiantes;
	}

	public boolean contieneAVIEJO(String nombre, int legajo) {
			return estudiantes.stream().anyMatch(e-> e.esIgual(nombre, legajo));
	}
	
	public boolean contieneA(String nombre, int legajo) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://notitas.herokuapp.com/student");
		ClientResponse response = webResource.header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho")
				.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);
		Integer code = new Integer(legajo);
	return 	output.contains(nombre) & output.contains(code.toString());
		
	}

	public Estudiante obtenerVIEJO(String nombreIngresado) {
		modelo.Estudiante est = null;
		for(int index=0;index<estudiantes.size();index++) {
		if( estudiantes.get(index).tieneNombreIgual(nombreIngresado)) {
			 est = estudiantes.get(index);
		}
		
	}return est;
	}
	
	public Estudiante obtener(String nombre) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://notitas.herokuapp.com/student");
		ClientResponse response = webResource.header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho")
				.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);
	 	if(output.contains(nombre)){
	 		Estudiante est = new Gson().fromJson(output,Estudiante.class);
	 		return est;
	 	}else {
	 		return null;
	 	}
	 		
	}
	
	public Estudiante obtenerPorLegajo(int legajo) {
		Estudiante est = null;
		for(int index=0;index<estudiantes.size();index++) {
			if( estudiantes.get(index).tieneLegajoIgual(legajo)) {
				 est = estudiantes.get(index);
			}
	}
		return est;
}
}

