package modelo;

import java.util.List;

public abstract class TareaD {
	private String title;
	private int id;
	private String description;
	private List<String> grades;
	public TareaD(String nombre) {
		super();
		this.title = nombre;
	}
	
	public void setNombre(String nombre) {
		this.title = nombre;
	}

	public String getNombre() {
		return title;
	}

	public boolean esLaTarea(String tarea) {
		return title.equals(tarea);
	}

	public abstract boolean esNumerica();
	public abstract void agregarAlumno(Estudiante estudiante);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGrades() {
		return grades;
	}

	public void setGrades(List<String> grades) {
		this.grades = grades;
	}
	

}