package server_http;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import conexion_http.Cliente;
import conexion_http.JsonToAsignacion;
import conexion_http.JsonToEstudiante;
import modelo.Asignacion;
import modelo.Estudiante;
import modelo.TareaHttp;
import modelo.TareaServer;


public class RepoAsignacionesServer {

	private static List<TareaServer> Tareas = new ArrayList<>();
	private static RepoAsignacionesServer repo;

	public static RepoAsignacionesServer getInstance() {
		if (repo == null) {
			repo = new RepoAsignacionesServer();
		}
		return repo;
	}

	public void agregar(TareaServer tarea) {
		Tareas.add(tarea);
	}

	public List<TareaServer> all() {
		return Tareas;
	}

	public boolean contieneA(TareaServer tarea) {
		return Tareas.stream().anyMatch(e -> e.esLaTarea(tarea.getNombre()));
	}
	
	public TareaHttp convertirHttp(TareaServer tarea) {
		TareaHttp tareanueva =new TareaHttp(tarea.getNombre());
		tareanueva.setDescription(tarea.getDescription());
		tareanueva.setGrades(tarea.getGrades());
		tareanueva.setId(tarea.getId());
		tareanueva.setTitle(tarea.getTitle());
		return tareanueva ;
	}


	public  List<TareaHttp> getTareasPorID(int id) {
		List<TareaHttp> tareasNuevas = new ArrayList<>();
		tareasNuevas =	Tareas.stream().filter(a->a.esDelAlumno(id)).map(tarea->this.convertirHttp(tarea)).collect(Collectors.toList());
		return tareasNuevas;
	}
	
	public List<TareaServer> obtenerAsignaciones(Estudiante estudiante){
		Cliente cliente = new Cliente();
		return JsonToAsignacion.main(cliente.getAsignaciones());
	
	}
}
