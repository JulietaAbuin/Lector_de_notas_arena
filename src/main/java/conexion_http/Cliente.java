package conexion_http;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Cliente {
	private Client cliente;
	private WebResource webResource;
	private static final String resource = "http://localhost:9000/";
	
	
	public Cliente() {
		this.cliente = Client.create();
	}
	
	public ClientResponse getEstudiante() {
		webResource = this.cliente.resource(Cliente.resource + "student");
		return webResource.header("Authorization","Bearer ")
				.accept("application/json").get(ClientResponse.class); 
	}
	
	public ClientResponse getAsignaciones() {
		webResource = this.cliente.resource(Cliente.resource + "student/assignments");
		return webResource.header("Authorization","Bearer ")
				.accept("application/json").get(ClientResponse.class); 
	}
}