package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.RepoDocentes;
import ui_vm_docente.DocenteViewModel;

public class DocenteWindow extends Dialog<DocenteViewModel>{
	private Label mensajeError;
	static DocenteViewModel viewModel = new DocenteViewModel();  
	
	public DocenteWindow(WindowOwner owner) {
		super(owner, viewModel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(1));
		new Label(form).setText("Nombre");
		new TextBox(form).setWidth(140).bindValueToProperty("nombreDocente");
		new Label(form).setText("Legajo");
		new NumericField(form).setWidth(140).bindValueToProperty("legajoDocente");
		this.setTitle("Lector de notas");
		this.mensajeError = new Label(form) ;
		new Button(form).setCaption("Volver").onClick(this::accept);
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Ingresar").onClick(this::confirmarDocente);
	}
	
	public void confirmarDocente() {
		if(RepoDocentes.getInstance().contieneA(viewModel.getLegajoDocente(), viewModel.getNombreDocente())) {
			Dialog<?> dialog = new CuentaDocenteWindow(this, RepoDocentes.getInstance().getDocentePorLegajo(viewModel.getLegajoDocente()));
			dialog.open();
			dialog.onAccept(() -> {});
		}else {
			this.mensajeError.setText("Legajo no encontrado");
		}
	}
}
