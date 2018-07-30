package ui_vm_docente;

import org.uqbar.commons.utils.Observable;

import modelo.Docente;

@Observable
public class ListadoDeAlumnosViewModel {
	private Docente docente;

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
}
