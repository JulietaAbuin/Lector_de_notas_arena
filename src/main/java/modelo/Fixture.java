package modelo;

import java.util.ArrayList;

public class Fixture {
	public static void initialize() {
		TareaNumerica ParcialIngles = new TareaNumerica("Parcial Ingles", new ArrayList<NotaNumerica>());
		TareaNumerica ParcialEconomia = new TareaNumerica("Parcial Economia", new ArrayList<NotaNumerica>());
		Asignacion Economia = new Asignacion("Economia", new ArrayList<TareaNumerica>(),
				new ArrayList<TareaConceptual>());
		Asignacion Ingles = new Asignacion("Ingles", new ArrayList<TareaNumerica>(), new ArrayList<TareaConceptual>());
		Estudiante juanito = new Estudiante("Juanito", "Carramal", 123456, "juaniCarra");
		Estudiante julieta = new Estudiante("Julieta", "Abuin", 345678, "JulietaAbuin");
		Estudiante juanchi = new Estudiante("Juanchi", "Fraga", 123456, "JuanchiFraga");
		Estudiante guido = new Estudiante("Guido", "Pavia", 1594850, "Gpavia");
		Estudiante enzo = new Estudiante("Enzo", "Conejero", 456781, "econejero");
		Docente mabel = new Docente("Mabel", "Lala", 1234);
		mabel.agregarTareaNumerica(Ingles,ParcialIngles);
		mabel.agregarTareaNumerica(Economia,ParcialEconomia);
		mabel.asignarTarea(Ingles, julieta, ParcialIngles);
		mabel.asignarTarea(Economia, julieta, ParcialEconomia);
		mabel.asignarTarea(Economia, juanito, ParcialEconomia);
		ParcialIngles.agregarNota(julieta, 4.0);
		ParcialIngles.agregarNota(julieta, 5.0);
		ParcialIngles.agregarNota(julieta, 6.0);
		ParcialEconomia.agregarNota(julieta, 7.0);
		RepoEstudiantes.getInstance().agregar(juanito);
		RepoEstudiantes.getInstance().agregar(julieta);
		RepoEstudiantes.getInstance().agregar(juanchi);
		RepoEstudiantes.getInstance().agregar(guido);
		RepoEstudiantes.getInstance().agregar(enzo);
		RepoDocentes.getInstance().agregar(mabel);
		RepoAsignaciones.getInstance().agregar(Economia);
		RepoAsignaciones.getInstance().agregar(Ingles);
	}
}
