package ui_windows_usuario;

import java.util.stream.Stream;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Estudiante;
import modelo.RepoEstudiantes;
import ui_vm_alumno.UsuarioViewModel;
import ui_windows.LectorNotasWindow;

public class UsuarioWindow extends Dialog<UsuarioViewModel> {
	static UsuarioViewModel model = new UsuarioViewModel();
	LectorNotasWindow owner;
	public Estudiante estudiante;
	
	public UsuarioWindow(LectorNotasWindow owner, Estudiante estudiante) {
		super(owner, model);
		this.estudiante = estudiante;
		this.owner = owner;
	}

	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(2));
		this.setTitle(estudiante.getNombre() +" "+ estudiante.getApellido());
		new Button(form).setCaption("Ver Notas").onClick(this::irANotas);
		new Button(form).setCaption("Actualizar cuenta").onClick(this::irACuenta);
		new Button(form).setCaption("Volver").onClick(this::accept);
		
		
	}
	public void irANotas() {
	Dialog<?> dialog = new NotasUsuarioWindow(this,estudiante);
	dialog.open();
	dialog.onAccept(() -> {});
	}
	
	public void irACuenta() {
		Dialog<?> dialog = new CuentaUsuario(this,estudiante);
		dialog.open();
		dialog.onAccept(() -> {});
	}
}
