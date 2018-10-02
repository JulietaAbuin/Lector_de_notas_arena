package modelo;

import java.util.ArrayList;
import java.util.List;

public class NotaConceptual extends Nota {
	private List<String> grades = new ArrayList<String>();
	
	public List<String> getNotasConceptuales() {
		return grades;
	}

	public NotaConceptual(Estudiante estudiante,List<String> notasConceptuales) {
		super(estudiante);
		this.grades = notasConceptuales;
	}

	public void agregarNotas(String notaConceptual){
		grades.add(notaConceptual);
	}
}
