package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	public String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public List<Asignacion> getTareasAsignadas() {
		return tareasAsignadas;
	}
	public void setTareasAsignadas(List<Asignacion> tareasAsignadas) {
		this.tareasAsignadas = tareasAsignadas;
	}
	public int legajo;
	public List<Asignacion> tareasAsignadas = new ArrayList<Asignacion>();
	public Estudiante(String string, int i) {
		nombre = string;
		legajo = i;
	}
	public void agregarAsignacion(Asignacion asig) {
		tareasAsignadas.add(asig);
		
	}
	public boolean esIgual(String nombre2, int legajo2) {
		
		return this.nombre.equals(nombre2) && this.legajo == legajo2;
	}
	public boolean tieneNombreIgual(String nombreIngresado) {
		return this.nombre.equals(nombreIngresado);
	} 
}
