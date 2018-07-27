package ui_windows_usuario;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Asignacion;
import modelo.Estudiante;
import ui_vm_alumno.NotasUsuarioViewModel;
import ui_vm_alumno.UsuarioViewModel;

public class NotasUsuarioWindow extends Dialog<NotasUsuarioViewModel> {
	static NotasUsuarioViewModel model = new NotasUsuarioViewModel();
	Estudiante estudiante;
	Panel panel;
	public String aprobacion;
	public NotasUsuarioWindow(WindowOwner owner,Estudiante est) {
		super(owner, model);
		estudiante = est;
	}

	@Override
	protected void createFormPanel(Panel panel) {
		this.panel = panel;
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(5));
		this.setTitle("Notas");
		
		
		estudiante.tareasAsignadas.forEach(asig -> this.crearAsignacion(asig,form));
		
		
		new Button(form).setCaption("Volver").onClick(this::accept);
		
	}

	private void crearAsignacion(Asignacion asignacion,Panel form) {
		new Label(form).setText(asignacion.tarea.nombreTarea).setWidth(120);
		for(int i=0;i<asignacion.notas.size();i++) {
		new Label(form).setText(asignacion.notas.get(i).toString()).setWidth(120);
		if(asignacion.notas.get(i) >= 6) {
			aprobacion = "APROBADO";
		}else {
			aprobacion = "DESAPROBADO";
		}
		new Label(form).setText(aprobacion).setWidth(120);
		}
		
	}
}
