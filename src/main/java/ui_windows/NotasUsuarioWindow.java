package ui_windows;

import java.util.stream.Stream;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Estudiante;
import ui_vm.UsuarioViewModel;

public class NotasUsuarioWindow extends Dialog<UsuarioViewModel> {
	static UsuarioViewModel model = new UsuarioViewModel();
	public NotasUsuarioWindow(LectorNotasWindow owner, modelo.Estudiante estudiante) {
		super(owner, model);
	}

	

	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(2));
		this.setTitle("Bienvenidos");
		
		
		
	}

}
