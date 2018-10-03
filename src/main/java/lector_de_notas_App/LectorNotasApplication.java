package lector_de_notas_App;

import org.uqbar.arena.Application;

import modelo.Fixture;
import ui_windows.LectorNotasWindow;



public class LectorNotasApplication extends Application{

	public static void main(String[] args) {
		Fixture.initialize();
		new LectorNotasApplication().start();
	}
	
	@Override
	protected LectorNotasWindow createMainWindow() {
		return new LectorNotasWindow(this);
	}
}
