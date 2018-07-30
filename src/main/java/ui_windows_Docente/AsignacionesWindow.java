package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Docente;
import ui_vm_docente.AsignacionesViewModel;
import ui_vm_docente.ModificarDocenteModelView;

public class AsignacionesWindow extends Dialog<AsignacionesViewModel> {
	
	public AsignacionesWindow(WindowOwner owner, Docente docente) {
		super(owner, new AsignacionesViewModel(docente));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));	
		new Button(form).setCaption("Nueva Asignacion").onClick(this::nuevaAsignacion);
		new Button(form).setCaption("Nueva Tarea").onClick(this::nuevaTarea);
		new Button(form).setCaption("Volver").onClick(this::accept);
	}

	private void nuevaAsignacion() {
		Dialog<?> dialog = new NuevaAsignacionWindow(this, this.getModelObject().getDocente());
		dialog.open();
		dialog.onAccept(() -> {});
	}
	
	private void nuevaTarea() {
		Dialog<?> dialog = new NuevaTareaWindow(this, this.getModelObject().getDocente());
		dialog.open();
		dialog.onAccept(() -> {});
	}
	
	
}
