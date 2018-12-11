package conexion_http;


public class DatosClienteWeb {

	public static void main(String args[]) {
		Cliente cliente = new Cliente();
		System.out.println(cliente.getEstudiante().getEntity(String.class));
		System.out.println(cliente.getAsignaciones().getEntity(String.class));
	}
}
