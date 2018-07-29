package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Docente;
import ui_vm_docente.CuentaDocenteViewModel;
import ui_vm_docente.NuevaAsignacionViewModel;
import ui_vm_docente.SubirNotaViewModel;

public class SubirNotaWindow extends Dialog<SubirNotaViewModel> {
	public SubirNotaWindow(WindowOwner owner, Docente docente) { 
		super(owner, new SubirNotaViewModel(docente));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Button(form).setCaption("Volver").onClick(this::accept);
	}
}
