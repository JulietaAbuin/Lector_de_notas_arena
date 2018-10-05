package modelo;

import java.util.List;

public class TareaHttp {
	private int id;
	private String title;
	private String description;
	private Integer[] grades;
	public TareaHttp(String nombre) {
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

	public Integer[] getGrades() {
		return grades;
	}

	public void setGrades(Integer[] grades) {
		this.grades = grades;
	}
	

}
