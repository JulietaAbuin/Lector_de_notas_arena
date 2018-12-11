package server_http;

import spark.Spark;
import server_http.Controller;

public class Router  {
	

	
	public void configure() {		
		SecurityService securityService = new SecurityService();
		Spark.before((req, res) -> {
			
			
		//	try {
				//Long userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
				req.session().attribute("userIdSession",345678);
			/* } catch (Exception e) {
				Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
			}*/
		}
		);

		Spark.get("/", (req, res) -> "Hello world!");
		
		Spark.get("/student", Controller::getAlumno);		
		
		Spark.get("/student/assignments", Controller::getAsignaciones);
		
		Spark.put("/student",  Controller::modificarAlumno);
		
		
	}

}
