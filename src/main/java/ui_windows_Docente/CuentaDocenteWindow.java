
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
		/*Supongo que hay mas cosas de lo que hace guido*/
		new Button(form).setCaption("Actualizar cuenta").onClick(this::actualizarCuenta);
		this.setTitle("MenudDocente");
	}
	
	private void actualizarCuenta() {
//		this.accept();
		Dialog<?> dialog = new ModificarDocenteWindow(this, this.getModelObject().getDocente());
		dialog.open();
		dialog.onAccept(() -> {});
	}

}