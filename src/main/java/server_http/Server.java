package server_http;

import modelo.Fixture;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		Fixture.initialize();
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		new Router().configure();
	}
}
