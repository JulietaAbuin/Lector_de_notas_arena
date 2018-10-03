package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TareaConceptual extends TareaD {
private List<NotaConceptual> grades = new ArrayList<NotaConceptual>();
	

	public List<NotaConceptual> getNotasNumericasXAlumnno() {
		return grades;
	}

	public TareaConceptual(String nombre, List<NotaConceptual> notasConceptualesXAlumnno) {
		super(nombre);
		this.grades = notasConceptualesXAlumnno;
	}
	
	public boolean esNumerica() {
		return false;
	}
	
	public void agregarNota(Estudiante estudiante, String notaConceptual){
		grades.add(new NotaConceptual(notaConceptual));
	}

	@Override
	public Boolean estaAprobada() {
		return  grades.stream().anyMatch(grade->grade.estaAprobada());
	}

}
