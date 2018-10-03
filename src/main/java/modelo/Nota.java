package modelo;

import java.time.LocalDateTime;

public abstract class  Nota {
	private int id;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public abstract Boolean estaAprobada();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
}
