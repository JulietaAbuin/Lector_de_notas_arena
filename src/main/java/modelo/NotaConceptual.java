package modelo;

import java.time.LocalDateTime;

public class NotaConceptual extends Nota {
	private String value;

	public String getNotasConceptuales() {
		return value;
	}

	public NotaConceptual(String value) {
		super();
		this.value = value;
	}

	public void agregarNota(String notaConceptual) {
		value = notaConceptual;
	}

	@Override
	public Boolean estaAprobada() {
		switch (value) {
		case "B+":
			return true;
		case "B":
			return true;
		case "B-":
			return true;

		default:
			return false;
		}
	}

}
