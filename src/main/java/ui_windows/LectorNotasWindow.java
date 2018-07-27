package ui_windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.RepoEstudiantes;
import ui_vm.LectorViewModel;
import ui_windows_usuario.UsuarioWindow;

public class LectorNotasWindow extends Dialog<LectorViewModel>{
	static LectorViewModel owner = new LectorViewModel();

	public LectorNotasWindow(WindowOwner parent) {
		super(parent, owner);
		
	}

	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(2));
		new Label(form).setText("Alumno");
		new TextBox(form).setWidth(140).bindValueToProperty("nombreIngresado");
		
		new Label(form).setText("Legajo");
		new NumericField(form).setWidth(140).bindValueToProperty("legajoIngresado");
		
		this.setTitle("Lector de notas");
	}
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Ingresar").onClick(this::confirmarEstudiante);
	}

	public void confirmarEstudiante() {
		
		if(RepoEstudiantes.getInstance().contieneA(owner.getNombreIngresado(),owner.getLegajoIngresado())){
			Dialog<?> dialog = new UsuarioWindow(this,RepoEstudiantes.getInstance().obtener(owner.getNombreIngresado()));
			dialog.open();
			dialog.onAccept(() -> {});
	
		}	
	}
}
