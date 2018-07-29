package ui_vm_docente;

import modelo.Docente;

public class AsignacionesViewModel {
	Docente docente;
	public AsignacionesViewModel(Docente docente) {
		this.docente=docente;
	}
	public Docente getDocente() {
		return docente;
	}

}
