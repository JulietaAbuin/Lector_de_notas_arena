package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conexion_http.Cliente;
import conexion_http.JsonToAsignacion;

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

	/*public List<TareaHttp> filtrarPorAlumno(Estudiante estudiante) {
		Cliente cliente = new Cliente();
		return JsonToAsignacion.main(cliente.getAsignaciones());
	}*/

	public Asignacion filtrarPorNombre(String asignacion) {
		Asignacion asig = null;
		for (int index = 0; index < asignaciones.size(); index++) {
			if (asignaciones.get(index).tieneNombreIgual(asignacion)) {
				asig = asignaciones.get(index);
			}

		}
		return asig;
	}

}
