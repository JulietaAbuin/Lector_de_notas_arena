package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui_vm_docente.DocenteViewModel;

public class DocenteWindow extends Dialog<DocenteViewModel>{

	static DocenteViewModel viewModel = new DocenteViewModel();  
	
	public DocenteWindow(WindowOwner owner) {
		super(owner, viewModel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));
		new Label(form).setText("Nombre");
		
		new Label(form).setText("Legajo");
		
		this.setTitle("Lector de notas");
	}
	
}
