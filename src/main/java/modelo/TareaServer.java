package modelo;

import java.util.List;

public class TareaServer {
	private String title;
	private int id;
	private String description;
	private List<String> grades;
	private Estudiante estudiante; 
	
	public boolean esDelAlumno (Long ID) {
		return estudiante.esIgualporID(ID);
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public TareaServer(String nombre) {
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
