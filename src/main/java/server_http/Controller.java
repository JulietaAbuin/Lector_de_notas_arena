package server_http;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import modelo.Estudiante;
import modelo.RepoAsignaciones;
import modelo.TareaHttp;
import scala.Console;
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
		
		public static String getAlumno(Request req, Response res) {		
			Estudiante estudiante = obtenerAlumnoSiExiste((int) req.session().attribute("userIdSession"));
			
			if(estudiante != null) {
				return estudiante.toJson();				
			}
			
			return null;
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
		
		public static String getAsignaciones(Request req, Response res) {		
			Estudiante estudiante = obtenerAlumnoSiExiste(req.session().attribute("userIdSession"));
			if(estudiante != null) {
				
				return "[" + RepoAsignacionesServer.getInstance().getTareasPorID( req.session().attribute("userIdSession")).get(0).toJson() + "]";
				
				
			}
		
			return null;
		}
}
