
package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Docente;
import ui_vm_docente.CuentaDocenteViewModel;

public class CuentaDocenteWindow extends Dialog<CuentaDocenteViewModel> {
	
	public CuentaDocenteWindow(WindowOwner owner, Docente docente) { 
		super(owner, new CuentaDocenteViewModel(docente));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));
		new Label(form).setText("Profesor/a " + this.getModelObject().getDocente().getNombre() );
		new Button(form).setCaption("Actualizar cuenta").onClick(this::actualizarCuenta);
		new Button(form).setCaption("Asignaciones y Notas").onClick(this::Asignaciones);
		new Button(form).setCaption("Volver").onClick(this::accept);
		this.setTitle("Menu Docente");

	}
	
	private void actualizarCuenta() {
		Dialog<?> dialog = new ModificarDocenteWindow(this, this.getModelObject().getDocente());
		dialog.open();
		dialog.onAccept(() -> {});
	}
	
	private void Asignaciones() {
		Dialog<?> dialog = new AsignacionesWindow(this, this.getModelObject().getDocente());
		dialog.open();
		dialog.onAccept(() -> {});
	}

}