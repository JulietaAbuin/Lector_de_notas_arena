package test_conexion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.api.client.*;
import conexion_http.Cliente;

public class ContextTest {
	Cliente cliente;
	ClientResponse response;

	@Before
	public void setUp() {
		cliente = new Cliente();
		response = cliente.getEstudiante();
	}

	@Test
	public void conexion() {
		assertEquals(200, response.getStatus());
	}

	@Test
	public void jsonAlumnoEstaBien() {
		String json = response.getEntity(String.class);
		assertTrue(json.contains("code"));
		assertTrue(json.contains("first_name"));
		assertTrue(json.contains("last_name"));
		assertTrue(json.contains("github_user"));

	}

}
