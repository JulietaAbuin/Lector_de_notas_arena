package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import ui_vm.UsuarioViewModel;


public class RepoEstudiantes {
	private List<Estudiante> estudiantes = new ArrayList<>();
	private static RepoEstudiantes repo;
	
	public static RepoEstudiantes getInstance() {
		if(repo == null) {
			repo = new RepoEstudiantes();
		}
		return repo;
	}
	
	public void agregar(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
	}

	public List<Estudiante> all() {
		return estudiantes;
	}

	public boolean contieneA(String nombre, int legajo) {
			return estudiantes.stream().anyMatch(e-> e.esIgual(nombre, legajo));
	}

	public Estudiante obtener(String nombreIngresado) {
		modelo.Estudiante est = null;
		for(int index=0;index<estudiantes.size();index++) {
		if( estudiantes.get(index).tieneNombreIgual(nombreIngresado)) {
			 est = estudiantes.get(index);
		}
		
	}return est;
	}
}
