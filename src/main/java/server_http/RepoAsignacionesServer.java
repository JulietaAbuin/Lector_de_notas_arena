package server_http;

import java.util.ArrayList;
import java.util.List;

import modelo.Asignacion;


public class RepoAsignacionesServer {
	
	private List<Asignacion> asignaciones = new ArrayList<>();
	private static RepoAsignacionesServer repo;

	public static RepoAsignacionesServer getInstance() {
		if (repo == null) {
			repo = new RepoAsignacionesServer();
		}
		return repo;
	}

	public void agregar(Asignacion asignacion) {
		this.asignaciones.add(asignacion);
	}

	public List<Asignacion> all() {
		return asignaciones;
	}

	public boolean contieneA(Asignacion materia) {
		return asignaciones.stream().anyMatch(e -> e.esLaAsignacion(materia.getNombre()));
	}
}
