package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui_vm_docente.DocenteAlumnosViewModel;
import ui_windows.LectorNotasWindow;
import ui_windows_Docente.DocenteWindow;

public class DocenteAlumnosWindow extends Dialog<DocenteAlumnosViewModel> {

	static DocenteAlumnosViewModel viewModel = new DocenteAlumnosViewModel();
	
	public DocenteAlumnosWindow(WindowOwner owner) {
		super(owner, viewModel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));
		new Label(form).setText("Seleccionar tipo de usuario");
		this.setTitle("Login");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Docente").onClick(this::logProfesor);
		new Button(actions).setCaption("Alumno").onClick(this::logAlumno);
	}

	private void logAlumno() {
		Dialog<?> dialog = new LectorNotasWindow(this);
		dialog.open();
		dialog.onAccept(() -> {});
		
	}
	
	private void logProfesor(){
		Dialog<?> dialog = new DocenteWindow(this);
		dialog.open();
		dialog.onAccept(() -> {});	
	}
}
