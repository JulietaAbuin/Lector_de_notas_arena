package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	public String nombre;
	public String legajo;
	public List<Asignacion> tareasAsignadas = new ArrayList<Asignacion>();
	public Estudiante(String string, String i) {
		nombre = string;
		legajo = i;
	}
	public void agregarAsignacion(Asignacion asig) {
		tareasAsignadas.add(asig);
		
	}
	public boolean esIgual(String nombre2, String legajo2) {
		
		return this.nombre == nombre2 && this.legajo == legajo2;
	} 
}
