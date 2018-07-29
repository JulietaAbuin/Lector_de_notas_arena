package modelo;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String usuariogit;
	private int legajo;
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getUsuariogit() {
		return usuariogit;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setUsuariogit(String usuariogit) {
		this.usuariogit = usuariogit;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public Estudiante(String nombre, String apellido, int legajo, String usuariogit) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuariogit = usuariogit;
	}
	
	public boolean esIgual(String nombre2, int legajo2) {
		
		return this.nombre.equals(nombre2) && this.legajo == legajo2;
	}
	public boolean tieneNombreIgual(String nombreIngresado) {
		return this.nombre.equals(nombreIngresado);
	}
	public boolean tieneLegajoIgual(int legajo2) {
		return legajo2 == this.legajo;
	}

}
