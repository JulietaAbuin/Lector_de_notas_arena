package modelo;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
	public static void initialize() {
		List<Double> lista = new ArrayList<Double>();
		lista.add(4.0);lista.add(6.5);
		List<Double> lista2 = new ArrayList<Double>();
		lista2.add(3.5);lista2.add(8.0);
		Asignacion asignacion1 = new Asignacion(new Parcial("Parcial Economia",TipoDeCalificacion.NUMERICA),lista);
		Asignacion asig2 = new Asignacion(new Parcial("Parcial Ingles",TipoDeCalificacion.NUMERICA),lista2);
		Estudiante juanito = new Estudiante("Juanito","Carramal",123456, "juaniCarra");
		Estudiante julieta = new Estudiante("Julieta","Abuin",345678,"JulietaAbuin");
		Estudiante juanchi = new Estudiante("Juanchi","Fraga",123456,"JuanchiFraga");
		Estudiante guido = new Estudiante ("Guido","Pavia",1594850,"Gpavia");
		Estudiante enzo = new Estudiante("Enzo","Conejero",456781,"econejero");
		Docente mabel = new Docente("Mabel", "Lala" , 1234);
		
	mabel.asignarTarea(asig2, julieta);	
	mabel.asignarTarea(asignacion1, julieta);
	mabel.asignarTarea(asignacion1, juanito);
		
	RepoEstudiantes.getInstance().agregar(juanito);
	RepoEstudiantes.getInstance().agregar(julieta);
	RepoEstudiantes.getInstance().agregar(juanchi);
	RepoEstudiantes.getInstance().agregar(guido);
	RepoEstudiantes.getInstance().agregar(enzo);
	
	RepoDocentes.getInstance().agregar(mabel);
	}
}
