package modelo;

public class Nota {
	private Estudiante alumno;

	public Nota(Estudiante alumno) {
		this.alumno = alumno;
	}

	public Estudiante getAlumno() {
		return alumno;
	}
	
	public boolean esElAlumno(Estudiante estudiante) {
		return alumno.esIgual(estudiante.getNombre(), estudiante.getLegajo());
	}
}
