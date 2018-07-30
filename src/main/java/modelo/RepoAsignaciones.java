package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoAsignaciones {
	private List<Asignacion> asignaciones = new ArrayList<>();
	private static RepoAsignaciones repo;

	public static RepoAsignaciones getInstance() {
		if (repo == null) {
			repo = new RepoAsignaciones();
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
	
	public List<Asignacion> filtrarPorAlumno(Estudiante estudiante){
		return asignaciones.stream().filter(asig -> asig.tieneAlumno(estudiante)).collect(Collectors.toList());
	}
	
	public Asignacion filtrarPorNombre(String asignacion){
		return asignaciones.stream().filter(asig -> asig.esLaAsignacion(asignacion)).collect(Collectors.toList()).get(0);
	}

}
