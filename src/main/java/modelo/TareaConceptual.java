package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TareaConceptual extends Tarea {
private List<NotaConceptual> notasConceptualesXAlumnno = new ArrayList<NotaConceptual>();
	

	public List<NotaConceptual> getNotasNumericasXAlumnno() {
		return notasConceptualesXAlumnno;
	}

	public TareaConceptual(String nombre, List<NotaConceptual> notasConceptualesXAlumnno) {
		super(nombre);
		this.notasConceptualesXAlumnno = notasConceptualesXAlumnno;
	}
	
	public boolean estaElAlumno(Estudiante estudiante) {
		return notasConceptualesXAlumnno.stream().anyMatch(nota ->nota.esElAlumno(estudiante));
	}
	
	public boolean esNumerica() {
		return false;
	}
	
	public void agregarNota(Estudiante estudiante, String notaConceptual){
		agregarAlumno(estudiante);
		notasXAlumno(estudiante).agregarNotas(notaConceptual);
	}
	
	public void agregarAlumno(Estudiante estudiante) {
		if(!estaElAlumno(estudiante)) {
			new NotaConceptual(estudiante, new ArrayList<String>());
		}
	}
	
	public NotaConceptual notasXAlumno(Estudiante estudiante) {
		return notasConceptualesXAlumnno.stream().filter(nota -> nota.esElAlumno(estudiante)).collect(Collectors.toList()).get(0);
	}
}
