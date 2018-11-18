package modelo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import conexion_http.Cliente;
import conexion_http.JsonToEstudiante;


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
		Cliente cliente = new Cliente();
		ClientResponse response = cliente.getEstudiante();
		Estudiante est = JsonToEstudiante.main(response);
	return est.tieneNombreIgual(nombre) & est.tieneLegajoIgual((long) legajo);
		
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
		Cliente cliente = new Cliente();
		return JsonToEstudiante.main(cliente.getEstudiante());
	}
	
	public Estudiante obtenerPorLegajo(Long long1) {
		Estudiante est = null;
		for(int index=0;index<estudiantes.size();index++) {
			if( estudiantes.get(index).tieneLegajoIgual(long1)) {
				 est = estudiantes.get(index);
			}
	}
		return est;
}

	
}

