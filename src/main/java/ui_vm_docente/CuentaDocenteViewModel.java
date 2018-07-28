package ui_vm_docente;

import modelo.Docente;

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
