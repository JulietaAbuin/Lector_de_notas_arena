package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TareaNumerica extends TareaD {
	private List<NotaNumerica> grades = new ArrayList<NotaNumerica>();
	
	public List<NotaNumerica> getNotasNumericasXAlumnno() {
		return grades;
	}

	public TareaNumerica(String nombre, List<NotaNumerica> notasNumericasXAlumnno) {
		super(nombre);
		this.grades = notasNumericasXAlumnno;
	}
	
	public boolean estaElAlumno(Estudiante estudiante) {
		return grades.stream().anyMatch(nota ->nota.esElAlumno(estudiante));
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
			grades.add(new NotaNumerica(estudiante, new ArrayList<Double>()));
		}
	}
	
	public NotaNumerica notasXAlumno(Estudiante estudiante) {
		return grades.stream().filter(nota -> nota.esElAlumno(estudiante)).collect(Collectors.toList()).get(0);
	}
	
}
