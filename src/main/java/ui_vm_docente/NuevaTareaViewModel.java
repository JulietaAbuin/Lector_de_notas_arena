package ui_vm_docente;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;

import modelo.Docente;
import modelo.Tarea;
import modelo.TareaNumerica;

@Observable
public class NuevaTareaViewModel {
	Docente docente;
	private String nombreTarea;
	private List<Tareas> tiposDeTarea = new ArrayList<Tareas>();
	private Tareas tipoDeTarea;
	private List<Double> notasNumericas = new ArrayList<Double>();
	
	public NuevaTareaViewModel() {
		this.docente=docente;
		tiposDeTarea.add(Tareas.CONCEPTUAL);
		tiposDeTarea.add(Tareas.NUMERICA);
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
}
