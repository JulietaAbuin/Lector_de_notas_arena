package ui_windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Estudiante;
import ui_vm.CuentaUsuarioViewModel;

public class CuentaUsuario extends Dialog<CuentaUsuarioViewModel> {
	public static CuentaUsuarioViewModel model = new CuentaUsuarioViewModel();
	UsuarioWindow owner;
	public Estudiante estudiante;
	public CuentaUsuario(UsuarioWindow owner, Estudiante estudiante) {
		super(owner, model);
		this.owner = owner;
		this.estudiante = estudiante;
	}

	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(3));
		new Label(form).setText("Nombre");
		new Label(form).setText(estudiante.nombre);
		new TextBox(form).setWidth(130).bindValueToProperty("nombreModificado");

		new Label(form).setText("Apellido");
		new Label(form).setText(estudiante.apellido);
		new TextBox(form).setWidth(130).bindValueToProperty("apellidoModificado");
		
		new Label(form).setText("Legajo");
		Integer legajo = estudiante.legajo;
		new Label(form).setText(legajo.toString());
		new NumericField(form).setWidth(130).bindValueToProperty("legajoModificado");
		
		new Label(form).setText("Usuario de github");
		new Label(form).setText(estudiante.usuariogit);
		new TextBox(form).setWidth(130).bindValueToProperty("usuarioGitModificado");
		
		new Button(form).setCaption("Modificar").onClick(this::aplicarModificacion);
		this.setTitle("Lector de notas");
		
		new Button(form).setCaption("Volver").onClick(this::accept);
		
	}
	public void aplicarModificacion() {
		model.aplicarModificacion(estudiante);
	}

}
