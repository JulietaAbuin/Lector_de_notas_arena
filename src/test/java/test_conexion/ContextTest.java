package test_conexion;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sun.jersey.api.client.*;
import conexion_http.Cliente;

public class ContextTest {


	@Test
	public void context() {
		Cliente cliente = new Cliente();
		ClientResponse response = cliente.getEstudiante();
		assertEquals(200, response.getStatus());
        String json = response.getEntity(String.class);
        assertTrue(json.contains("code"));
        assertTrue(json.contains("first_name"));
        assertTrue(json.contains("last_name"));
        assertTrue(json.contains("github_user"));
	}
	
}
