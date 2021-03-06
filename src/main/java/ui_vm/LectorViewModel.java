package ui_vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.Estudiante;
import modelo.RepoEstudiantes;


@Observable
public class LectorViewModel {
	
	public String nombreIngresado;
	public int legajoIngresado;
	public List<Estudiante> estudiantes;

	public LectorViewModel() {
		estudiantes = RepoEstudiantes.getInstance().all();
	}

	public String getNombreIngresado() {
		return nombreIngresado;
	}

	public void setNombreIngresado(String nombreIngresado) {
		this.nombreIngresado = nombreIngresado;
	}

	public int getLegajoIngresado() {
		return legajoIngresado;
	}

	public void setLegajoIngresado(int legajoIngresado) {
		this.legajoIngresado = legajoIngresado;
	}
	
	

}

