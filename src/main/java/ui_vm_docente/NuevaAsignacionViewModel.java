package ui_vm_docente;

import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

import modelo.Asignacion;
import modelo.Docente;
import modelo.RepoAsignaciones;
import modelo.TareaConceptual;
import modelo.TareaNumerica;

@Observable
public class NuevaAsignacionViewModel {
private Docente docente;
private String nombre;

	
	public NuevaAsignacionViewModel(Docente docente) {
		this.docente = docente;
	}
	
	public void crearAsignacion() {
		RepoAsignaciones.getInstance().agregar(new Asignacion(nombre, new ArrayList<TareaNumerica>(), new ArrayList<TareaConceptual>()));
	}

}
