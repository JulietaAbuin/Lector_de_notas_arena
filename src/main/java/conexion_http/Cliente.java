package conexion_http;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Cliente {
	private Client cliente;
	private WebResource webResource;
	private static final String resource = "http://notitas.herokuapp.com/";
	private static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	
	public Cliente() {
		this.cliente = Client.create();
	}
	
	public ClientResponse getEstudiante() {
		webResource = this.cliente.resource(Cliente.resource + "student");
		return webResource.header("Authorization","Bearer " + Cliente.token)
				.accept("application/json").get(ClientResponse.class); 
	}
	
	public ClientResponse getAsignaciones() {
		webResource = this.cliente.resource(Cliente.resource + "student/assignments");
		return webResource.header("Authorization","Bearer " + Cliente.token)
				.accept("application/json").get(ClientResponse.class); 
	}
}