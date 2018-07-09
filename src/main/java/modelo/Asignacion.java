package modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignacion {
	private Tarea tarea;
	public List<Float> notas = new ArrayList<Float>();
	public Asignacion(Tarea tarea) {
		this.tarea = tarea;
	}
	
}
