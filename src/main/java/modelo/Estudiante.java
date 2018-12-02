package modelo;

import java.util.List;
import java.util.Optional;

public class Estudiante {
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String first_name;
	private String last_name;
	private String github_user;
	private int code;
	
	public String getNombre() {
		return first_name;
	}
	public String getApellido() {
		return last_name;
	}
	public String getUsuariogit() {
		return github_user;
	}
	public int getLegajo() {
		return code;
	}
	public void setNombre(String nombre) {
		this.first_name = nombre;
	}
	public void setApellido(String apellido) {
		this.last_name = apellido;
	}
	public void setUsuariogit(String usuariogit) {
		this.github_user = usuariogit;
	}
	public void setLegajo(int legajo) {
		this.code = legajo;
	}
	
	public Estudiante(String nombre, String apellido, int legajo, String usuariogit) {
		super();
		this.first_name = nombre;
		this.last_name = apellido;
		this.code = legajo;
		this.github_user = usuariogit;
	}
	
	public boolean esIgual(String nombre2, int legajo2) {
		
		return this.first_name.equals(nombre2) && this.code == legajo2;
	}
	
public boolean esIgualporID(long id2) {
		
		return (this.getId()==id2);
	}
	public boolean tieneNombreIgual(String nombreIngresado) {
		return this.first_name.equals(nombreIngresado);
	}
	public boolean tieneLegajoIgual(int legajo2) {
		return legajo2 == this.code;
	}
	public List<TareaHttp> getAsignaciones() {
		return RepoAsignaciones.getInstance().filtrarPorAlumno(this);
	}
	
	public String toJson() {
		return "{ id = \""+ this.id +"\","
						+ "first_name : \""+ this.first_name +"\","
						+ "last_name : \""+ this.last_name +"\""
						+ "github_user : \""+ this.github_user +"\","
						+ "code : \""+ this.code +"\""
						+ " }";
	}
	
	public Optional<String> getAsignacionesToJson() {
		return getAsignaciones().stream().map(x -> x.toJson()).
				reduce( (a,b) -> a + ", " + b ); 
	}

}
