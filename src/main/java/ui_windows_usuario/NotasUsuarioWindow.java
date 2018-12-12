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
import modelo.TareaD;
import modelo.TareaHttp;
import modelo.TareaConceptual;
import modelo.TareaNumerica;
import modelo.TareaServer;
import server_http.RepoAsignacionesServer;
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

		RepoAsignacionesServer.getInstance().obtenerAsignaciones(estudiante)
		.forEach(tarea -> this.crearAsignacion(tarea, estudiante, form));
		
		new Button(form).setCaption("Volver").onClick(this::accept);

	}

	private void crearAsignacion(TareaServer tarea, Estudiante estudiante, Panel form) {
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText(tarea.getNombre()).setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);
		new Label(form).setText("").setWidth(120);	

		//tarea.filtrarTareasNumericasXAlumno(estudiante).forEach(esaTarea -> this.crearTareaNumerica(esaTarea, estudiante, form));
		//tarea.filtrarTareasConceptualesXAlumno(estudiante).forEach(esaTarea -> this.crearTareaConceptual(esaTarea, estudiante, form));

	}

	private void crearTareaNumerica(TareaNumerica tarea, Estudiante estudiante, Panel form) {
		new Label(form).setText(tarea.getNombre()).setWidth(120);
		Integer numero;
		int primera_iteracion = 1;
		
		for (int i = 0; i <  tarea.notasXAlumno(estudiante).getNotasNumerica().size(); i++) {
			numero=i;
			if(primera_iteracion==0) {
				new Label(form).setText("").setWidth(120);
			}
			new Label(form).setText( "instancia Nº" + numero.toString() ).setWidth(120);
			new Label(form).setText( tarea.notasXAlumno(estudiante).getNotasNumerica().get(i).toString()).setWidth(120);
			primera_iteracion=0;
			if ( tarea.notasXAlumno(estudiante).getNotasNumerica().get(i) >= 6.0) {
				aprobacion = "APROBADO";
			} else {
				aprobacion = "DESAPROBADO";
			}
			new Label(form).setText(aprobacion).setWidth(120);

		}
	}
	
	private void crearTareaConceptual(TareaConceptual tarea, Estudiante estudiante, Panel form) {
		new Label(form).setText(tarea.getNombre()).setWidth(120);
		Integer numero;
		int primera_iteracion = 1;
		for (int i = 0; i <  tarea.notasXAlumno(estudiante).getNotasConceptuales().size(); i++) {
			numero=i;
			if(primera_iteracion==0) {
				new Label(form).setText("").setWidth(120);
			}
			new Label(form).setText( "instancia Nº" + numero.toString() ).setWidth(120);
			new Label(form).setText( tarea.notasXAlumno(estudiante).getNotasConceptuales().get(i).toString()).setWidth(120);
			primera_iteracion=0;
			
			if ( tarea.notasXAlumno(estudiante).getNotasConceptuales().get(i).equals("B")) {
				aprobacion = "APROBADO";
			} else if ( tarea.notasXAlumno(estudiante).getNotasConceptuales().get(i).equals("B-")) {
				aprobacion = "APROBADO";
			}else if ( tarea.notasXAlumno(estudiante).getNotasConceptuales().get(i).equals("B+")) {
				aprobacion = "APROBADO";
			}
			else {
				aprobacion = "DESAPROBADO";
			}
			new Label(form).setText(aprobacion).setWidth(120);
		}
	}

}
