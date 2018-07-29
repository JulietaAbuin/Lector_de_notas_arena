package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import modelo.Docente;
import modelo.Tarea;
import ui_vm_alumno.NotasUsuarioViewModel;
import ui_vm_docente.CuentaDocenteViewModel;
import ui_vm_docente.NuevaAsignacionViewModel;
import ui_vm_docente.NuevaTareaViewModel;
import ui_vm_docente.Tareas;


public class NuevaTareaWindow extends Dialog<NuevaTareaViewModel> {
	static NuevaTareaViewModel model=new NuevaTareaViewModel();
	private Docente docente;
	Panel form;
	public NuevaTareaWindow(WindowOwner owner, Docente docente) { 
		super(owner, model);
		this.docente = docente;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
	     form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		new Label(form).setText("Nombre").setWidth(220);
		new TextBox(form).bindValueToProperty("nombreTarea");
		
		new Label(form).setText("Tipo de tarea").setWidth(220);
		Selector<Tareas> selectorTarea=new Selector<Tareas>(form).allowNull(true);
		selectorTarea.bindValueToProperty("tipoDeTarea");
		selectorTarea.bindItemsToProperty("tiposDeTarea");
		//selectorTarea.onSelection(this::agregarBox);
		
		new Label(form).setText("Legajo del estudiante").setWidth(220);
		new NumericField(form).setWidth(220).bindValueToProperty("legajoEstudiante");
		
		new Label(form).setText("Nota 1").setWidth(220);
		new TextBox(form).setWidth(120).bindValueToProperty("nota1");

		new Label(form).setText("Nota 2").setWidth(220);
		new TextBox(form).setWidth(120).bindValueToProperty("nota2");
		
		new Label(form).setText("Nota 3").setWidth(220);
		new TextBox(form).setWidth(120).bindValueToProperty("nota3");
		
		new Label(form).setText("Nota 4").setWidth(220);
		new TextBox(form).setWidth(120).bindValueToProperty("nota4");
		
		new Button(form).setCaption("Crear Tarea").onClick(this::crearTarea);
		new Button(form).setCaption("Volver").onClick(this::accept);
		
		
	}
	public void crearTarea() {
		model.crearTarea();
	}
}
