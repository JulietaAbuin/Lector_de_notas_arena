package modelo;

public class Docente {
	public void asignarTarea(Asignacion asig,Estudiante estudiante) {
		estudiante.agregarAsignacion(asig);
	}
}
