
package ui_windows_Docente;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Docente;
import ui_vm_docente.CuentaDocenteViewModel;

public class CuentaDocenteWindow extends Dialog<CuentaDocenteViewModel> {

	static CuentaDocenteViewModel viewModel = new CuentaDocenteViewModel();
	
	public CuentaDocenteWindow(WindowOwner owner, Docente docente) {
		super(owner, viewModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

}
