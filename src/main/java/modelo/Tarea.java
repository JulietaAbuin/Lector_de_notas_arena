package modelo;
public abstract class Tarea {
	public TipoDeCalificacion tipoDeCalificacion;
	public String nombreTarea;
	public Tarea(String nombreTarea,TipoDeCalificacion tipo) {
		this.tipoDeCalificacion = tipo;
		this.nombreTarea = nombreTarea;
	}
}
