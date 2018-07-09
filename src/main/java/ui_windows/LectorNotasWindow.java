package ui_windows;

import java.awt.Color;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Estudiante;
import ui_vm.LectorViewModel;

public class LectorNotasWindow extends SimpleWindow<LectorViewModel>{
	public LectorNotasWindow(WindowOwner parent) {
		super(parent, new LectorViewModel());
	}
	

	@Override
	protected void addActions(Panel panel) {
		
	}

	@Override
	protected void createFormPanel(Panel panel) {
		new Label(panel).setText("Alumno").setBackground(Color.CYAN);
		new TextBox(panel).setWidth(10);
		this.setTitle("Lector de notas");
		new Button(panel).setCaption("Ingresar");
	}
}
