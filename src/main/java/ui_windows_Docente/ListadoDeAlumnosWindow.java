package ui_windows_Docente;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Docente;
import ui_vm_docente.ListadoDeAlumnosViewModel;

public class ListadoDeAlumnosWindow extends Dialog<ListadoDeAlumnosViewModel> {
	static ListadoDeAlumnosViewModel model = new ListadoDeAlumnosViewModel();
	public ListadoDeAlumnosWindow(WindowOwner owner, Docente docente) {
		super(owner, model);
		model.setDocente(docente);
	}
	@Override
	protected void createFormPanel(Panel arg0) {
		Panel form = new Panel(arg0);
		form.setLayout(new ColumnLayout(4));
		for(int i=0;i< model.getDocente().getEstudiantesModificados().size();i++) {
			new Label(form).setText(model.getDocente().getEstudiantesModificados().get(i).getNombre());
			new Label(form).setText(model.getDocente().getEstudiantesModificados().get(i).getApellido());
			Integer legajo = new Integer(model.getDocente().getEstudiantesModificados().get(i).getLegajo());
			new Label(form).setText(legajo.toString());
			new Label(form).setText(model.getDocente().getEstudiantesModificados().get(i).getUsuariogit());
		}
		new Button(form).setCaption("Volver").onClick(this::accept);
		
		this.setTitle("Mis alumnos");
	}

}
