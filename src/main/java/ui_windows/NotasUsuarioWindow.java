package ui_windows;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui_vm.NotasUsuarioViewModel;
import ui_vm.UsuarioViewModel;

public class NotasUsuarioWindow extends Dialog<NotasUsuarioViewModel> {
	static NotasUsuarioViewModel model = new NotasUsuarioViewModel();

	public NotasUsuarioWindow(WindowOwner owner) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel panel) {
		
	}

}
