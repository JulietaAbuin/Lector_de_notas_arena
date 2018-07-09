package modelo;

public abstract class Tarea {
	private TipoDeCalificacion tipoDeCalificacion;
	private String nombreTarea;
	public Tarea(String nombreTarea,TipoDeCalificacion tipo) {
		this.tipoDeCalificacion = tipo;
		this.nombreTarea = nombreTarea;
	}
}
