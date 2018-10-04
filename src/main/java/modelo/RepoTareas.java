package modelo;

import java.util.List;

import conexion_http.Cliente;
import conexion_http.JsonToAsignacion;
import conexion_http.jsonGenerico;

public class RepoTareas {

private static RepoTareas repo;
	
	public static RepoTareas getInstance() {
		if(repo == null) {
			repo = new RepoTareas();
		}
		return repo;
	}


	public List<TareaHttp> filtrarPorAlumno(Estudiante estudiante) {
		Cliente cliente = new Cliente();
		return JsonToAsignacion.main(cliente.getAsignaciones());
	}

}
