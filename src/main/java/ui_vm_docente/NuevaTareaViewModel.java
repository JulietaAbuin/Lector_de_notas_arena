package ui_vm_docente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.Observable;

import modelo.Asignacion;
import modelo.Docente;
import modelo.Estudiante;
import modelo.NotaConceptual;
import modelo.NotaNumerica;
import modelo.RepoAsignaciones;
import modelo.RepoEstudiantes;
import modelo.TareaConceptual;
import modelo.TareaNumerica;

@Observable
public class NuevaTareaViewModel {
	private Docente docente;
	private String nombreTarea;
	private List<Tareas> tiposDeTarea = new ArrayList<Tareas>();
	private Tareas tipoDeTarea;
	private List<Double> notasNumericas = new ArrayList<Double>();
	private List<String> notasConceptuales = new ArrayList<String>();
	private String nota1,nota2,nota3,nota4;
	private int legajoEstudiante;
	private List<String> asignaciones = new ArrayList<String>();
	private String asignacion;
	private Asignacion asignacionPosta;
	
	public List<String> getAsignaciones() {
		return asignaciones;
	}

	public String getAsignacion() {
		return asignacion;
	}

	public void setAsignaciones(List<String> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}

	
	public NuevaTareaViewModel(Docente docente) {
		this.docente=docente;
		tiposDeTarea.add(Tareas.CONCEPTUAL);
		tiposDeTarea.add(Tareas.NUMERICA);
		asignaciones.addAll(RepoAsignaciones.getInstance().all().stream().map(asig->asig.toString()).collect(Collectors.toList()));
	}

	public String getNota1() {
		return nota1;
	}

	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}

	public String getNota2() {
		return nota2;
	}

	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}

	public String getNota3() {
		return nota3;
	}

	public void setNota3(String nota3) {
		this.nota3 = nota3;
	}

	public String getNota4() {
		return nota4;
	}

	public void setNota4(String nota4) {
		this.nota4 = nota4;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public void agregarBox(Panel form) {
			if(tipoDeTarea.equals(Tareas.NUMERICA)) {
			 new NumericField(form).setWidth(120);
			}else {
				new TextBox(form);
			}
	}
	
	public List<Tareas> getTiposDeTarea() {
		return tiposDeTarea;
	}
	public void setTiposDeTarea(List<Tareas> tiposDeTarea) {
		this.tiposDeTarea = tiposDeTarea;
	}
	public Tareas getTipoDeTarea() {
		return tipoDeTarea;
	}
	public void setTipoDeTarea(Tareas tipoDeTarea) {
		this.tipoDeTarea = tipoDeTarea;
	}
	public List<Double> getNotasNumericas() {
		return notasNumericas;
	}
	public void setNotasNumericas(List<Double> notasNumericas) {
		this.notasNumericas = notasNumericas;
	}

	public void crearTarea() {
		if(tipoDeTarea.equals(Tareas.NUMERICA)) {
			notasNumericas.add(Double.parseDouble(nota1));
			notasNumericas.add(Double.parseDouble(nota2));
			notasNumericas.add(Double.parseDouble(nota3));
			notasNumericas.add(Double.parseDouble(nota4));
			List<NotaNumerica> notas = new ArrayList<NotaNumerica>();
			Estudiante estud = RepoEstudiantes.getInstance().obtenerPorLegajo(legajoEstudiante);
			notas.add(new NotaNumerica(estud, notasNumericas));
		TareaNumerica tarea=new TareaNumerica(nombreTarea,notas);
		docente.agregarTareaNumerica(asignacionPosta, tarea);
	}
		if(tipoDeTarea.equals(Tareas.CONCEPTUAL)) {
			notasConceptuales.add(nota1);
			notasConceptuales.add(nota2);
			notasConceptuales.add(nota3);
			notasConceptuales.add(nota4);
			List<NotaConceptual> notas = new ArrayList<NotaConceptual>();
			Estudiante estud = RepoEstudiantes.getInstance().obtenerPorLegajo(legajoEstudiante);
			notas.add(new NotaConceptual(estud, notasConceptuales));
		TareaConceptual tarea=new TareaConceptual(nombreTarea,notas);
		docente.agregarTareaConceptual(asignacionPosta, tarea);
	}	
}

	public int getLegajoEstudiante() {
		return legajoEstudiante;
	}

	public void setLegajoEstudiante(int legajoEstudiante) {
		this.legajoEstudiante = legajoEstudiante;
	}

	public List<String> getNotasConceptuales() {
		return notasConceptuales;
	}

	public void setNotasConceptuales(List<String> notasConceptuales) {
		this.notasConceptuales = notasConceptuales;
	}
}
