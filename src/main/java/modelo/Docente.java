package modelo;

public class Docente {
	private String nombre;

	private String apellido;
	private int legajo;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Docente(String nombre, String apellido,int legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.apellido = apellido;
	}

	public void asignarTarea(Asignacion asig,Estudiante estudiante) {
		estudiante.agregarAsignacion(asig);
	}
	
	@Override
	public int hashCode() {
		return this.legajo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		return obj.hashCode() == this.hashCode();
	}

	public String getNombre() {
		return nombre;
	}

	public int getLegajo() {
		return legajo;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
