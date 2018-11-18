package server_http;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import modelo.Asignacion;
import modelo.Estudiante;

public class Controller {
	public class AlumnoController {
		
		private static final JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();	
		
		private static Alumno obtenerAlumnoSiExiste(Long id) {
			Alumno alumno = RepoAlumnos.getInstance().obtenerXId(id);
			
			if (alumno == null) {
				Spark.halt(401, "Me mandaste cualquier cosaa, no te hagas el gil");
			}
			
			return alumno;		
		}
		
		public static Alumno getAlumno(Request req, Response res) {		
			return obtenerAlumnoSiExiste((Long) req.session().attribute("userIdSession"));
		}
		
		public static String modificarAlumno(Request req, Response res) {
			Alumno alumnoActual = obtenerAlumnoSiExiste(req.session().attribute("userIdSession"));		
			Alumno alumnoNuevo = parserAlumnos.jsonToObject(req.body(), Alumno.class);
			
			alumnoActual.setNombre(alumnoNuevo.getNombre() != null ? alumnoNuevo.getNombre() : alumnoActual.getNombre());
			alumnoActual.setEmail(alumnoNuevo.getEmail() != null ? alumnoNuevo.getEmail() : alumnoActual.getEmail());
			alumnoActual.setApellido(alumnoNuevo.getApellido() != null ? alumnoNuevo.getApellido() : alumnoActual.getApellido());
			alumnoActual.setGithubUser(alumnoNuevo.getGithubUser() != null ? alumnoNuevo.getGithubUser() : alumnoActual.getGithubUser());
			
			return "OK";
		}
		
		public static List<Asignacion> getAsignaciones(Request req, Response res) {
			return obtenerAlumnoSiExiste(req.session().attribute("userIdSession")).getAsignaciones();
		}
		
}
