package http_server;

import com.google.gson.Gson;

import modelo.Estudiante;
import modelo.RepoAsignaciones;
import modelo.RepoEstudiantes;
import spark.Request;
import spark.Response;

public class Controller {

    private static RepoEstudiantes repo = RepoEstudiantes.getInstance();

    private static String getAsJSON(Object object) {
    	
        return new Gson().toJson(object);
    }

    public static String getAsignacionesAsJSON(Request req, Response res) {
        return getAsJSON(RepoAsignaciones.getInstance().getAsignaciones(getUserId(req)));
    }

    private static Long getUserId(Request req) {
        return req.session().attribute("userId");
    }

    public static String getAlumnoAsJSON(Request req, Response res) {
        return getAsJSON(repo.obtenerPorLegajo(getUserId(req)));
    }

    public static String setAlumno(Request req, Response res) {
        Estudiante nuevoAlumno = new Gson().fromJson(req.body(), Estudiante.class);
        repo.actualizarAlumno(getUserId(req), nuevoAlumno);
        return "done";
    }
}
