package lector_de_notas_App;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import modelo.Fixture;
import ui_windows.LectorNotasWindow;
import ui_windows_Docente.DocenteAlumnosWindow;


public class LectorNotasApplication extends Application{

	public static void main(String[] args) {
		Fixture.initialize();
		new LectorNotasApplication().start();
	}
	
//	@Override
//	protected LectorNotasWindow createMainWindow() {
//		return new LectorNotasWindow(this);
//	}
	
	@Override
	protected DocenteAlumnosWindow createMainWindow() {
		return new DocenteAlumnosWindow(this);
	}
}
