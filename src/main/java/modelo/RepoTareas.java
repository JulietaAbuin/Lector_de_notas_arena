package modelo;

import java.util.List;

public class RepoTareas {

private static RepoTareas repo;
	
	public static RepoTareas getInstance() {
		if(repo == null) {
			repo = new RepoTareas();
		}
		return repo;
	}

	public List<Tarea> filtrarPorAlumno(Estudiante estudiante) {
	
		return null;
	}

}
