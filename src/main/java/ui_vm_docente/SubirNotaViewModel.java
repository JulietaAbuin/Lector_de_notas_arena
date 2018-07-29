package ui_vm_docente;

import org.uqbar.commons.utils.Observable;

import modelo.Docente;
@Observable
public class SubirNotaViewModel {
	Docente docente;
	public SubirNotaViewModel(Docente docente) {
		this.docente=docente;
	}

}
