package modelo;

import java.util.ArrayList;

import server_http.RepoAsignacionesServer;
import server_http.RepoEstudiantesServer;

public class Fixture {
	public static void initialize() {
		Integer uno = new Integer(1);
		Integer dos = new Integer(2);
		TareaNumerica ParcialIngles = new TareaNumerica("Parcial Ingles", new ArrayList<NotaNumerica>());
		TareaNumerica ParcialEconomia = new TareaNumerica("Parcial Economia", new ArrayList<NotaNumerica>());
		Asignacion Economia = new Asignacion("Economia", new ArrayList<TareaNumerica>(),
				new ArrayList<TareaConceptual>());
		Asignacion Ingles = new Asignacion("Ingles", new ArrayList<TareaNumerica>(), new ArrayList<TareaConceptual>());
		Estudiante juanito = new Estudiante("Juanito", "Carramal", 123456, "juaniCarra");
		Estudiante julieta = new Estudiante("Julieta", "Abuin", 345678, "JulietaAbuin");
		Estudiante juanchi = new Estudiante("Juanchi", "Fraga", 123457, "JuanchiFraga");
		Estudiante guido = new Estudiante("Guido", "Pavia", 1594850, "Gpavia");
		Estudiante enzo = new Estudiante("Enzo", "Conejero", 456781, "econejero");
		Docente mabel = new Docente("Mabel", "Lala", 1234);
		mabel.agregarTareaNumerica(Ingles,ParcialIngles);
		mabel.agregarTareaNumerica(Economia,ParcialEconomia);
		mabel.asignarTarea(Ingles, julieta, ParcialIngles);
		mabel.modificarAlumno(julieta);
		mabel.asignarTarea(Economia, julieta, ParcialEconomia);
		mabel.modificarAlumno(julieta);
		mabel.asignarTarea(Economia, juanito, ParcialEconomia);		
		mabel.modificarAlumno(juanito);
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
		RepoEstudiantesServer.getInstance().agregar(julieta);
		TareaServer tarea = new TareaServer("Ingles");
		tarea.setEstudiante(julieta);
		RepoAsignacionesServer.getInstance().agregar(tarea);
		
		
	}
}
