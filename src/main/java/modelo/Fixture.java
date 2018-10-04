package modelo;

import java.util.ArrayList;

public class Fixture {
	public static void initialize() {
		Tarea ParcialIngles = new Tarea("Parcial", " Ingles");
		Tarea ParcialEconomia = new Tarea("Parcial", " Economia");
		Estudiante juanito = new Estudiante("Juanito", "Carramal", 123456, "juaniCarra");
		Estudiante julieta = new Estudiante("Julieta", "Abuin", 345678, "JulietaAbuin");
		Estudiante juanchi = new Estudiante("Juanchi", "Fraga", 123457, "JuanchiFraga");
		Estudiante guido = new Estudiante("Guido", "Pavia", 1594850, "Gpavia");
		Estudiante enzo = new Estudiante("Enzo", "Conejero", 456781, "econejero");
		ParcialIngles.agregarNotaNumerica( 4.0);
		ParcialIngles.agregarNotaNumerica(5.0);
		ParcialIngles.agregarNotaNumerica(6.0);
		ParcialEconomia.agregarNotaNumerica(7.0);
		RepoEstudiantes.getInstance().agregar(juanito);
		RepoEstudiantes.getInstance().agregar(julieta);
		RepoEstudiantes.getInstance().agregar(juanchi);
		RepoEstudiantes.getInstance().agregar(guido);
		RepoEstudiantes.getInstance().agregar(enzo);
	}
}
