package ui_windows_usuario;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import modelo.Estudiante;
import modelo.NotaNumerica;
import modelo.RepoTareas;
import modelo.Tarea;
import modelo.TareaHttp;
import ui_vm_alumno.NotasUsuarioViewModel;

public class NotasUsuarioWindow extends Dialog<NotasUsuarioViewModel> {
	static NotasUsuarioViewModel model = new NotasUsuarioViewModel();
	Estudiante estudiante;
	Panel panel;
	public String aprobacion;

	public NotasUsuarioWindow(WindowOwner owner, Estudiante est) {
		super(owner, model);
		estudiante = est;
	}

	@Override
	protected void createFormPanel(Panel panel) {
		this.panel = panel;
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(4));
		this.setTitle("Notas");

		RepoTareas.getInstance().filtrarPorAlumno(estudiante).
			forEach(tarea -> crearAsignacion(tarea, estudiante, form));
		
		new Button(form).setCaption("Volver").onClick(this::accept);
	}

<<<<<<< HEAD
	private void crearAsignacion(Tarea tarea, Estudiante estudiante, Panel form) {
=======

	private void crearAsignacion(TareaHttp tarea, Estudiante estudiante, Panel form) {

		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
>>>>>>> bfbd15019845078dbb8201dc940175e0b91c5bf9
		new Label(form).setText(tarea.getNombre()).setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);	

	}



}
