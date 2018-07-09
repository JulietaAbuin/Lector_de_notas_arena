package modelo;



public class Fixture {
	public static void initialize() {
		Asignacion asignacion1 = new Asignacion(new Parcial("Parcial economia",TipoDeCalificacion.NUMERICA));
		Estudiante juanito = new Estudiante("juanito",123456);
		Estudiante julietita = new Estudiante("julietita",345678);
		Docente mabel = new Docente();
		//mabel.asignarTarea(asignacion1, julietita);
	//	mabel.asignarTarea(asignacion1, juanito);
		
	/*
		Repositorios.prendas.agregar(pantalonNegroSarkani);
		Repositorios.prendas.agregar(camisaMangaCortaSarkani);
		Repositorios.prendas.agregar(sacoVioleta);*/
	}
}
