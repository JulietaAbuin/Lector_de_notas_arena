package ui_windows_usuario;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Asignacion;
import modelo.Estudiante;
import modelo.NotaNumerica;
import modelo.RepoAsignaciones;
import modelo.TareaNumerica;
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
		form.setLayout(new ColumnLayout(5));
		this.setTitle("Notas");

		RepoAsignaciones.getInstance().filtrarPorAlumno(estudiante)
				.forEach(asig -> this.crearAsignacion(asig, estudiante, form));

		new Button(form).setCaption("Volver").onClick(this::accept);

	}

	private void crearAsignacion(Asignacion asignacion, Estudiante estudiante, Panel form) {
		new Label(form).setText(asignacion.getNombre()).setWidth(120);

		asignacion.filtrarTareasNumericasXAlumno(estudiante).forEach(esaTarea -> this.crearTareaNumerica(esaTarea, estudiante, form));

	}

	private void crearTareaNumerica(TareaNumerica tarea, Estudiante estudiante, Panel form) {
		Integer numero;
		for (int i = 0; i <  tarea.notasXAlumno(estudiante).getNotasNumerica().size(); i++) {
			numero=i;
			new Label(form).setText( "instancia Nº" + numero.toString() ).setWidth(120);
			new Label(form).setText( tarea.notasXAlumno(estudiante).getNotasNumerica().get(i).toString()).setWidth(120);
			
			if ( tarea.notasXAlumno(estudiante).getNotasNumerica().get(i) >= 6.0) {
				aprobacion = "APROBADO";
			} else {
				aprobacion = "DESAPROBADO";
			}
			new Label(form).setText(aprobacion).setWidth(120);

		}
	}

}
