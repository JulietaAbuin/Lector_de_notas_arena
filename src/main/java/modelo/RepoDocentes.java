package modelo;

import java.util.ArrayList;
import java.util.List;

public class RepoDocentes {
	private List<Docente> docentes = new ArrayList<>();
	private static RepoDocentes repo;
	
	public static RepoDocentes getInstance() {
		if(repo == null) {
			repo = new RepoDocentes();
		}
		return repo;
	}
	
	public Docente getDocentePorLegajo(int legajo) {
		for(int indice = 0; indice < docentes.size(); indice ++) {
			if(docentes.get(indice).hashCode() == legajo) {
				return docentes.get(indice);
			}
		}
		return null;
	}
	
	public void agregar(Docente estudiante) {
		this.docentes.add(estudiante);
	}

	public List<Docente> all() {
		return docentes;
	}

	public boolean contieneA(int legajo, String nombre) {
		return docentes.stream().anyMatch(e -> (e.hashCode() == legajo) && e.getNombre().equals(nombre));
	}

}
