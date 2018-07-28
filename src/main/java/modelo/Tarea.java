package modelo;

public abstract class Tarea {
	private String nombre;

	public Tarea(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean esLaTarea(String tarea) {
		return nombre.equals(tarea);
	}

	public abstract boolean esNumerica();
	public abstract void agregarAlumno(Estudiante estudiante);
	

}
