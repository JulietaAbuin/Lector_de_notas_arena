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
	
	public boolean esNumerica() {
		return true;
	}
	
	public void agregarNota(Estudiante estudiante, Double notaNumerica){
		grades.add(new NotaNumerica(notaNumerica));
	}

	@Override
	public Boolean estaAprobada() {
		return grades.stream().anyMatch(grade->grade.estaAprobada());
	}
	
	
	
}
