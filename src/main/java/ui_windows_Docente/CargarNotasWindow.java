package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Docente;
import ui_vm_docente.CargarNotasModelView;
import ui_vm_docente.ModificarDocenteModelView;

public class CargarNotasWindow extends Dialog<CargarNotasModelView> {
	public CargarNotasWindow(WindowOwner owner, Docente docente) {
		super(owner, new CargarNotasModelView(docente));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre");
		new TextBox(form).setWidth(130).bindValueToProperty("nombreModificado");

		new Label(form).setText("Apellido");
		new TextBox(form).setWidth(130).bindValueToProperty("apellidoModificado");
	
		new Button(form).setCaption("Modificar").onClick(this::aplicarModificacion);
		this.setTitle("Lector de notas");
		
		new Button(form).setCaption("Volver").onClick(this::accept);
	}

	private void aplicarModificacion() {
		this.accept();
		this.getModelObject().aplicarModificacion();
	}
}
