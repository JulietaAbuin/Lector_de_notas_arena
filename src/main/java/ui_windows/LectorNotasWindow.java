package ui_windows;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Estudiante;
import ui_vm.LectorViewModel;

public class LectorNotasWindow extends SimpleWindow<LectorViewModel>{
	public LectorNotasWindow(WindowOwner parent) {
		super(parent, new LectorViewModel());
	}

	@Override
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel panel) {
		new Label(panel).setText("Alumno");
	}
}
