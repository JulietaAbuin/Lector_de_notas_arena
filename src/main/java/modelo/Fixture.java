package modelo;



public class Fixture {
	public static void initialize() {
		Asignacion asignacion1 = new Asignacion(new Parcial("Parcial economia",TipoDeCalificacion.NUMERICA));
		Estudiante juanito = new Estudiante("Juanito","Carramal",123456, "juaniCarra");
		Estudiante julieta = new Estudiante("Julieta","Abuin",345678,"JulietaAbuin");
		Estudiante juanchi = new Estudiante("Juanchi","Fraga",123456,"JuanchiFraga");
		Estudiante guido = new Estudiante ("Guido","Pavia",1594850,"Gpavia");
		Estudiante enzo = new Estudiante("Enzo","Conejero",456781,"econejero");
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
