package ui_vm_docente;

import org.uqbar.commons.utils.Observable;

import modelo.Docente;

@Observable

public class AsignacionesViewModel {
	Docente docente;
	public AsignacionesViewModel(Docente docente) {
		this.docente=docente;
	}
	public Docente getDocente() {
		return docente;
	}

}
