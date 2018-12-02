package server_http;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public Estudiante obtenerporID(long id) {
	Estudiante est = null;
	est=estudiantes.stream().filter(e->e.esIgualporID(id)).collect(Collectors.toList()).get(0);
	return est;
	}
	
}
