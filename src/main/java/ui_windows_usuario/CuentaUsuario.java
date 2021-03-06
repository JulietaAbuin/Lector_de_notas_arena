package ui_windows_usuario;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Estudiante;
import ui_vm_alumno.CuentaUsuarioViewModel;

public class CuentaUsuario extends Dialog<CuentaUsuarioViewModel> {
	public static CuentaUsuarioViewModel model = new CuentaUsuarioViewModel();
	UsuarioWindow owner;
	public Estudiante estudiante;
	public CuentaUsuario(UsuarioWindow owner, Estudiante estudiante) {
		super(owner, model);
		this.owner = owner;
		this.estudiante = estudiante;
		model.setNombre(estudiante.getNombre());
		model.setApellido(estudiante.getApellido());
		model.setUsuarioGit(estudiante.getUsuariogit());
	}

	
	
	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(3));
		new Label(form).setText("Nombre");
		new Label(form).bindValueToProperty ("nombre");
		new TextBox(form).setWidth(130).bindValueToProperty("nombreModificado");

		new Label(form).setText("Apellido");
		new Label(form).bindValueToProperty("apellido");
		new TextBox(form).setWidth(130).bindValueToProperty("apellidoModificado");
		
		new Label(form).setText("Usuario de github");
		new Label(form).bindValueToProperty("usuarioGit");
		new TextBox(form).setWidth(130).bindValueToProperty("usuarioGitModificado");
		
		new Button(form).setCaption("Modificar").onClick(this::aplicarModificacion);
		this.setTitle("Lector de notas");
		
		new Button(form).setCaption("Volver").onClick(this::accept);
		
	}
	
	public void aplicarModificacion() {
		this.accept();
		model.aplicarModificacion(estudiante);
	}

}
