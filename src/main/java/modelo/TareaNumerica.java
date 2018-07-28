package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TareaNumerica extends Tarea {
	private List<NotaNumerica> notasNumericasXAlumnno = new ArrayList<NotaNumerica>();
	
	public List<NotaNumerica> getNotasNumericasXAlumnno() {
		return notasNumericasXAlumnno;
	}

	public TareaNumerica(String nombre, List<NotaNumerica> notasNumericasXAlumnno) {
		super(nombre);
		this.notasNumericasXAlumnno = notasNumericasXAlumnno;
	}
	
	public boolean estaElAlumno(Estudiante estudiante) {
		return notasNumericasXAlumnno.stream().anyMatch(nota ->nota.esElAlumno(estudiante));
	}
	
	public boolean esNumerica() {
		return true;
	}
	
	public void agregarNota(Estudiante estudiante, Double notaNumerica){
		agregarAlumno(estudiante);
		notasXAlumno(estudiante).agregarNotas(notaNumerica);
	}
	
	public void agregarAlumno(Estudiante estudiante) {
		if(!estaElAlumno(estudiante)) {
			new NotaNumerica(estudiante, new ArrayList<Double>());
		}
	}
	
	public NotaNumerica notasXAlumno(Estudiante estudiante) {
		return notasNumericasXAlumnno.stream().filter(nota -> nota.esElAlumno(estudiante)).collect(Collectors.toList()).get(0);
	}
	
}
