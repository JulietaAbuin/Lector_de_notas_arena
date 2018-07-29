package ui_vm_docente;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.Observable;

import modelo.Docente;

@Observable

public class ModificarDocenteModelView {
	private Docente docente;
	private String nombreModificado;
	private String apellidoModificado;
		
	public ModificarDocenteModelView(Docente docente) {
		this.docente = docente;
		this.nombreModificado = docente.getNombre();
		this.apellidoModificado = docente.getApellido();
	}
	
	public void aplicarModificacion() {
		docente.setApellido(apellidoModificado);
		docente.setNombre(nombreModificado);
	}
	
	public String getNombreModificado() {
		return nombreModificado;
	}
	
	public void setNombreModificado(String nombreModificado) {
		this.nombreModificado = nombreModificado;
	}
	
	public String getApellidoModificado() {
		return apellidoModificado;
	}
	
	public void setApellidoModificado(String apellidoModificado) {
		this.apellidoModificado = apellidoModificado;
	}
	
	public Docente getDocente() {
		return docente;
	}
		
}
