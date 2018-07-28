package ui_vm_docente;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.Docente;
import modelo.RepoDocentes;

@Observable
public class DocenteViewModel {
	private String nombreDocente;
	private int legajoDocente;
	private List<Docente> docentes;
	
	public List<Docente> getDocentes() {
		return docentes;
	}

	public DocenteViewModel() {
		docentes = RepoDocentes.getInstance().all();
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreIngresado) {
		this.nombreDocente = nombreIngresado;
	}

	public int getLegajoDocente() {
		return legajoDocente;
	}

	public void setLegajoDocente(int legajoIngresado) {
		this.legajoDocente = legajoIngresado;
	}
}
