package modelo;

public class Docente {
	private String nombre;
	private int legajo;

	public Docente(String nombre, int legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
	}

	public void asignarTarea(Asignacion asig , Estudiante estudiante, Tarea tarea) {
		asig.agregarEstudianteATarea(estudiante,tarea);
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
	
}
