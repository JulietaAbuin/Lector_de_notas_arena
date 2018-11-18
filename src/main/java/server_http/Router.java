package server_http;

import spark.Spark;

public class Router implements TransactionalOps, WithGlobalEntityManager {
	
	EntityManager em = entityManager();
	
	public void configure() {		
//		SecurityService securityService = new SecurityService("god");
		SecurityService securityService = new SecurityService();
		Spark.before((req, res) -> {
			if (req.requestMethod() != "GET") {
				beginTransaction();
			}
			
			try {
				Long userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
				req.session().attribute("userIdSession", userId);
			} catch (InvalidTokenException e) {
				if (req.requestMethod() != "GET") {
					rollbackTransaction();
				}
				
				Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
			}
		});

		Spark.get("/", (req, res) -> "Hello world!");
		
		Spark.get("/student", Controller::getAlumno, new AlumnoToJsonTransformer());		
		
		Spark.get("/student/asignaciones", Controller::getAsignaciones, new AlumnoAsignacionesToJsonTransformer());
		
		Spark.patch("/student", Controller::modificarAlumno);
		
		Spark.after((req, res) -> {
			if(req.requestMethod() != "GET") {
				try {
					commitTransaction();
					em.clear();
				} catch (RollbackException e) {
					rollbackTransaction();
				}				
			}
		});
	}

}
