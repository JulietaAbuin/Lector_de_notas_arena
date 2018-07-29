package ui_vm_docente;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;

import modelo.Docente;
import modelo.NotaNumerica;
import modelo.Tarea;
import modelo.TareaNumerica;

@Observable
public class NuevaTareaViewModel {
	Docente docente;
	private String nombreTarea;
	private List<Tareas> tiposDeTarea = new ArrayList<Tareas>();
	private Tareas tipoDeTarea;
	private List<Double> notasNumericas = new ArrayList<Double>();
	private String nota1,nota2,nota3,nota4;
	public NuevaTareaViewModel() {
		this.docente=docente;
		tiposDeTarea.add(Tareas.CONCEPTUAL);
		tiposDeTarea.add(Tareas.NUMERICA);
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
			//Sacar el parametro del estudiante para poder crear una nota numerica?
			//se lo asigna al estudiante recien en la asignacion?
			notas.add(new NotaNumerica(null, notasNumericas));
		TareaNumerica tarea=new TareaNumerica(nombreTarea,notas);
		//hacer repo de tareas y agregarla al repo para despues agregarla a la 
		//asignacion ??
	}
}
}
