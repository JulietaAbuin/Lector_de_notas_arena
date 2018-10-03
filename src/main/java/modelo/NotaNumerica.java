package modelo;

import java.time.LocalDateTime;


public class NotaNumerica extends Nota {
	
public NotaNumerica(Double value) {
		super();
		this.value = value;
	}

private Double value;
	
	public Double getNotasNumerica() {
	return value;
}

	public void agregarNota(Double notaNumerica){
		value=notaNumerica;
	}

	@Override
	public Boolean estaAprobada() {
		// TODO Auto-generated method stub
		return value>=6;
	}
}
