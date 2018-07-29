package ui_vm_docente;

import org.uqbar.commons.utils.Observable;

import modelo.Docente;
@Observable
public class CuentaDocenteViewModel{
	private Docente docente;

	public CuentaDocenteViewModel(Docente docente) {
		super();
		this.docente = docente;
	}

	public Docente getDocente() {
		return docente;
	}
	
	
}
