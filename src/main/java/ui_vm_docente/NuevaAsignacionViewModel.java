package ui_vm_docente;

import org.uqbar.commons.utils.Observable;

import modelo.Docente;
@Observable
public class NuevaAsignacionViewModel {
private Docente docente;
	
	public NuevaAsignacionViewModel(Docente docente) {
		this.docente = docente;
	}

}
