package http_server;

import spark.Spark;

public class Router {
	 static void route() {
	        Spark.get("/", (req, res) -> "<marquee>Holiis!</marquee>");
	        Spark.get("/student", Controller::getAlumnoAsJSON);
	        Spark.get("/student/assignments", Controller::getAsignacionesAsJSON);
	        Spark.put("/student", Controller::setAlumno);

	        Spark.before((req, res) -> {
	            String secret = System.getenv("NOTITAS_SECRET");
	            SecurityService securityService = new SecurityService(secret);
	            try {
	                Long userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
	                req.session().attribute("userId", userId);
	            } catch (Exception e) {
	                Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
	            }
	        });
	    }
}
