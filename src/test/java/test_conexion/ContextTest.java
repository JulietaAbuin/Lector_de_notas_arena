package test_conexion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ContextTest {

	@Test
	public void contextUp() {
		Client client = Client.create();

		WebResource webResource = client.resource("http://notitas.herokuapp.com/student");

		ClientResponse response = webResource.header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho")
				.accept("application/json").get(ClientResponse.class);
		assertEquals(200, response.getStatus());
	}

	

}
