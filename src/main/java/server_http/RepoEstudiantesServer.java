package server_http;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.jersey.api.client.ClientResponse;

import conexion_http.Cliente;
import conexion_http.JsonToEstudiante;
import modelo.Estudiante;

public class RepoEstudiantesServer {
	
	private List<Estudiante> estudiantes = new ArrayList<>();
	
private static RepoEstudiantesServer repo;
	
	public static RepoEstudiantesServer getInstance() {
		if(repo == null) {
			repo = new RepoEstudiantesServer();
		}
		return repo;
	}
	
	public void agregar(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
	}

	public List<Estudiante> all() {
		return estudiantes;
	}
	
	public Estudiante obtenerporID(int id) {
	Estudiante est = null;
	est=estudiantes.stream().filter(e->e.esIgualporID(id)).collect(Collectors.toList()).get(0);
	return est;
	}
	
	public Estudiante obtener() {
		Cliente cliente = new Cliente();
		return JsonToEstudiante.main(cliente.getEstudiante());
	}
	
	public boolean contieneA(String nombre, int legajo) {
		Cliente cliente = new Cliente();
		ClientResponse response = cliente.getEstudiante();
		Estudiante est = JsonToEstudiante.main(response);
	return est.tieneNombreIgual(nombre) & est.tieneLegajoIgual(legajo);
		
	}
	
}
