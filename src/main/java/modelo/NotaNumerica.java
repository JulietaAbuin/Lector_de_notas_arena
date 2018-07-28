package modelo;

import java.util.ArrayList;
import java.util.List;

public class NotaNumerica extends Nota {
private List<Double> notasNumerica = new ArrayList<Double>();
	
	public List<Double> getNotasNumerica() {
	return notasNumerica;
}

	public NotaNumerica(Estudiante alumno,List<Double> notasNumerica) {
		super(alumno);
		this.notasNumerica = notasNumerica;
	}

	public void agregarNotas(Double notaNumerica){
		notasNumerica.add(notaNumerica);
	}
}
