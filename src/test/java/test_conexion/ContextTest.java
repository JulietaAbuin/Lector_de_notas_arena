package test_conexion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.api.client.*;
import conexion_http.Cliente;
import conexion_http.EstudianteToJson;

public class ContextTest {
	Cliente cliente;
	ClientResponse response;

	@Before
	public void setUp() {
		cliente = new Cliente();
		
	}

	@Test
	public void conexionGET() {
		response = cliente.getEstudiante();
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void conexionPUT() {
		response = cliente.putEstudiante(EstudianteToJson.pasarAJson(111222333, "Bart", "Simpsons", "Growler"));
		assertEquals(201, response.getStatus());
	}

	@Test
	public void jsonAlumnoEstaBien() {
		response = cliente.getEstudiante();
		String json = response.getEntity(String.class);
		assertTrue(json.contains("code"));
		assertTrue(json.contains("first_name"));
		assertTrue(json.contains("last_name"));
		assertTrue(json.contains("github_user"));

	}

}
