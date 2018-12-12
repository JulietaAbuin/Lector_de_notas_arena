package modelo;

import java.util.List;
import java.util.Optional;

public class TareaHttp {
	private String title;
	private int id;
	private String description;
	private List<String> grades;
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

	public List<String> getGrades() {
		return grades;
	}

	public void setGrades(List<String> grades) {
		this.grades = grades;
	}
	
	public String toJson() {
		
		Optional<String> grados = grades.stream().map( x -> "\""+ x + "\"").reduce((a,b) -> a + ", " + b);
		
		
		String json = "{"
				+ "title : \"" + this.title + "\","  
				+ "id : \"" + this.id + "\","
				+ "description : \"" + this.description + "\","
				+ "grades : [" + grados.get().toString() + "]"
				+ "}";
		
		return json;
	}
}
