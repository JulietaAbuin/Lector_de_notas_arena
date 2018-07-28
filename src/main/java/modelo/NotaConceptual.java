package modelo;

import java.util.ArrayList;
import java.util.List;

public class NotaConceptual extends Nota {
	private List<String> notasConceptuales = new ArrayList<String>();
	
	public List<String> getNotasConceptuales() {
		return notasConceptuales;
	}

	public NotaConceptual(Estudiante estudiante,List<String> notasConceptuales) {
		super(estudiante);
		this.notasConceptuales = notasConceptuales;
	}

	public void agregarNotas(String notaConceptual){
		notasConceptuales.add(notaConceptual);
	}
}
