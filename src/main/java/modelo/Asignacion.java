package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Asignacion {
	private String nombre;
	private List<TareaNumerica> tareasNumericas = new ArrayList<TareaNumerica>();
	private List<TareaConceptual> tareasConceptuales = new ArrayList<TareaConceptual>();

	public Asignacion(String nombre, ArrayList<TareaNumerica> tareasNumericas, ArrayList<TareaConceptual> arrayList) {
		this.nombre = nombre;
		this.tareasNumericas = tareasNumericas;
		this.tareasConceptuales = arrayList;
	}

	public String getNombre() {
		return nombre;
	}

	public List<TareaNumerica> getTareasNumericas() {
		return tareasNumericas;
	}

	public List<TareaConceptual> getTareasConceptuales() {
		return tareasConceptuales;
	}

	public boolean existeTareaNumerica(TareaD tareaNueva) {
		return tareasNumericas.stream().anyMatch(tarea -> tarea.esLaTarea(tareaNueva.getNombre()));
	}

	public boolean existeTareaConceptual(TareaD tareaNueva) {
		return tareasConceptuales.stream().anyMatch(tarea -> tarea.esLaTarea(tareaNueva.getNombre()));
	}

	public boolean esLaAsignacion(String materia) {
		return nombre.equals(materia);
	}

	public void agregarEstudianteATarea(Estudiante estudiante, TareaD tarea) {
		if (tarea.esNumerica()) {
			this.agregarEstudianteATareaNumerica(estudiante, tarea);

		} else {
			this.agregarEstudianteATareaConceptual(estudiante, tarea);
		}
	}

	private void agregarEstudianteATareaNumerica(Estudiante estudiante, TareaD tareaNueva) {
		tareasNumericas.stream().filter(tarea -> tarea.esLaTarea(tareaNueva.getNombre())).collect(Collectors.toList())
				.get(0).agregarAlumno(estudiante);
	}

	private void agregarEstudianteATareaConceptual(Estudiante estudiante, TareaD tareaNueva) {
		tareasConceptuales.stream().filter(tarea -> tarea.esLaTarea(tareaNueva.getNombre()))
				.collect(Collectors.toList()).get(0).agregarAlumno(estudiante);
	}

	public boolean tieneAlumno(Estudiante estudiante) {
		return tareasNumericas.stream().anyMatch(tarea -> tarea.estaElAlumno(estudiante))
				|| tareasConceptuales.stream().anyMatch(tarea -> tarea.estaElAlumno(estudiante));
	}

	public List<TareaNumerica> filtrarTareasNumericasXAlumno(Estudiante estudiante) {
		return tareasNumericas.stream().filter(tarea -> tarea.estaElAlumno(estudiante)).collect(Collectors.toList());
	}

	public List<TareaConceptual> filtrarTareasConceptualesXAlumno(Estudiante estudiante) {
		return tareasConceptuales.stream().filter(tarea -> tarea.estaElAlumno(estudiante)).collect(Collectors.toList());
	}

	public void agregarTareaNumerica(TareaNumerica tarea) {
		tareasNumericas.add(tarea);
	}

	public void agregarTareaConceptual(TareaConceptual tarea) {
		tareasConceptuales.add(tarea);
		
	}

	public boolean tieneNombreIgual(String asignacion) {
		return this.nombre.equals(asignacion);
	}

}
