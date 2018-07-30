package modelo;

import java.util.ArrayList;
import java.util.List;

public class Docente {
	private String nombre;
	private String apellido;
	private int legajo;
	private List<Estudiante> estudiantesModificados = new ArrayList<Estudiante>();

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Docente(String nombre, String apellido,int legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.apellido = apellido;
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
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void agregarTareaNumerica(Asignacion asig, TareaNumerica tarea) {
		asig.agregarTareaNumerica(tarea);
	}
	
	public void agregarTareaConceptual(Asignacion asig, TareaConceptual tarea) {
		asig.agregarTareaConceptual(tarea);
	}

	public List<Estudiante> getEstudiantesModificados() {
		return estudiantesModificados;
	}

	public void setEstudiantesModificados(List<Estudiante> estudiantesModificados) {
		this.estudiantesModificados = estudiantesModificados;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public void modificarAlumno(Estudiante estudiante) {
		if(!estudiantesModificados.contains(estudiante)) {
			estudiantesModificados.add(estudiante);
		}
	}
	
}
