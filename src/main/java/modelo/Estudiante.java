package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	public String nombre;
	private int legajo;
	public List<Asignacion> tareasAsignadas = new ArrayList<Asignacion>();
	public Estudiante(String string, int i) {
		nombre = string;
		legajo = i;
	}
	public void agregarAsignacion(Asignacion asig) {
		tareasAsignadas.add(asig);
		
	} 
}
