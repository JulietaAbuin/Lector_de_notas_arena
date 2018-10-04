package modelo;

import java.util.ArrayList;
import java.util.List;

public  class Tarea {
	private String title;
	private int id;
	private String description;
	private List<Nota> grades = new ArrayList();
	
	public Tarea(String nombre, String description) {
		this.title = nombre;
		this.description=description;
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
	
	public void agregarNotaConceptual(String nota){
		grades.add(new NotaConceptual(nota));
	}
	
	public void agregarNotaNumerica(Double nota){
		grades.add(new NotaNumerica(nota));
	}

	public Boolean estaAprobada() {
		return  grades.stream().anyMatch(grade->grade.estaAprobada());
	}

}
