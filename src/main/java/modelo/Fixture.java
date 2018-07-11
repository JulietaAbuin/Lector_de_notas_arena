package modelo;



public class Fixture {
	public static void initialize() {
		Asignacion asignacion1 = new Asignacion(new Parcial("Parcial economia",TipoDeCalificacion.NUMERICA));
		Estudiante juanito = new Estudiante("Juanito",123456);
		Estudiante julieta = new Estudiante("Julieta",345678);
		Estudiante juanchi = new Estudiante("Juanchi",123456);
		Estudiante guido = new Estudiante ("Guido",789451);
		Estudiante enzo = new Estudiante("Enzo",456781);
		Docente mabel = new Docente();
		
	mabel.asignarTarea(asignacion1, julieta);
	mabel.asignarTarea(asignacion1, juanito);
		
	RepoEstudiantes.getInstance().agregar(juanito);
	RepoEstudiantes.getInstance().agregar(julieta);
	RepoEstudiantes.getInstance().agregar(juanchi);
	RepoEstudiantes.getInstance().agregar(guido);
	RepoEstudiantes.getInstance().agregar(enzo);
	}
}
