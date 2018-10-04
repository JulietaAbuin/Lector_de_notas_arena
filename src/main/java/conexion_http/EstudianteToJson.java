package conexion_http;

public class EstudianteToJson {

	public static String pasarAJson(Integer legajo, String nombre, String apellido, String usuarioGit) {
		String json = "{ \" code\" : \"" +  legajo.toString() + "\"," +
	            " \"first_name\":\"" + nombre + "\"," + 
	            " \"last_name\":\"" +  apellido + "\"," +
	            " \"github_user\":\"" + usuarioGit + "\"}" ;

		return json;
	}

}
