package ui_windows;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.Layout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import modelo.Estudiante;
import modelo.RepoEstudiantes;
import ui_vm.LectorViewModel;

public class LectorNotasWindow extends Dialog<LectorViewModel>{
	public LectorNotasWindow(WindowOwner parent) {
		super(parent, new LectorViewModel());
	}
	

	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(2));
		new Label(form).setText("Alumno");
		new TextBox(form).setWidth(70).bindValueToProperty("nombreIngresado");
		
		new Label(form).setText("Legajo");
		new NumericField(form).setWidth(70).bindValueToProperty("legajoIngresado");
		
		this.setTitle("Lector de notas");
	}
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Ingresar").onClick(this::confirmarEstudiante);
	}

	protected void confirmarEstudiante() {
		
		if(RepoEstudiantes.getInstance().contieneA("nombreIngresado","legajoIngresado")){
			System.out.println("me encontre");
		};
	
	}
}
