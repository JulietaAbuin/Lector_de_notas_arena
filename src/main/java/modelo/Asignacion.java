package modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignacion {
	public Tarea tarea;
	public List<Double> notas = new ArrayList<Double>();
	public Asignacion(Tarea tarea,List<Double> lista) {
		this.tarea = tarea;
		this.notas = lista;
	}
	
}
