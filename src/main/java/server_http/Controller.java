package server_http;

import java.util.List;
import com.google.gson.Gson;
import modelo.Estudiante;
import modelo.TareaHttp;
import spark.Request;
import spark.Response;
import spark.Spark;

public class Controller {
				
		private static  Estudiante obtenerAlumnoSiExiste(int id) {
			Estudiante alumno = RepoEstudiantesServer.getInstance().obtenerporID(id);
			
			if (alumno == null) {
				Spark.halt(401, "No existe el usuario");
			}
			
			return alumno;		
		}
		
		public static Estudiante getAlumno(Request req, Response res) {		
			return obtenerAlumnoSiExiste((int) req.session().attribute("userIdSession"));
		}
		
		public static String modificarAlumno(Request req, Response res) {
			Estudiante alumnoActual = obtenerAlumnoSiExiste(req.session().attribute("userIdSession"));		
			Estudiante alumnoNuevo = new Gson().fromJson(req.body(),Estudiante.class);
			alumnoActual.setNombre(alumnoNuevo.getNombre() != null ? alumnoNuevo.getNombre() : alumnoActual.getNombre());
			alumnoActual.setApellido(alumnoNuevo.getApellido() != null ? alumnoNuevo.getApellido() : alumnoActual.getApellido());
			alumnoActual.setUsuariogit(alumnoNuevo.getUsuariogit() != null ? alumnoNuevo.getUsuariogit() : alumnoActual.getUsuariogit());
			return "OK";
		}
		
		public static List<TareaHttp> getTareas(Request req, Response res) {
			return RepoAsignacionesServer.getInstance().getTareasPorID(req.session().attribute("userIdSession"));
		}
		

}
