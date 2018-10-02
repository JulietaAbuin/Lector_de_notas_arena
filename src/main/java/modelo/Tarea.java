package modelo;

public abstract class Tarea {
	private String title;
	private int id;
	private String description;

	public Tarea(String nombre) {
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
	

}
