package ui_vm;

import org.uqbar.commons.utils.Observable;

import modelo.Estudiante;
import modelo.RepoEstudiantes;

@Observable
public class CuentaUsuarioViewModel {

		public String nombreModificado;
		public String apellidoModificado;
		public int legajoModificado;
		public String usuarioGitModificado;
		
		
		public void aplicarModificacion(Estudiante estudiante) {
			if(nombreModificado!= "") {
				estudiante.setNombre(nombreModificado);
			}
			if(apellidoModificado!= "") {
				estudiante.setApellido(apellidoModificado);
			}
			if(legajoModificado != 0) {
				estudiante.setLegajo(legajoModificado);
			}
			if(usuarioGitModificado != "") {
				estudiante.setUsuariogit(usuarioGitModificado);
			}
			Estudiante estudianteNuevo = new Estudiante(estudiante.nombre,estudiante.apellido,estudiante.legajo,estudiante.usuariogit);
			RepoEstudiantes.getInstance().agregar(estudianteNuevo);
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
		public int getLegajoModificado() {
			return legajoModificado;
		}
		public void setLegajoModificado(int legajoModificado) {
			this.legajoModificado = legajoModificado;
		}
		public String getUsuarioGitModificado() {
			return usuarioGitModificado;
		}
		public void setUsuarioGitModificado(String usuarioGitModificado) {
			this.usuarioGitModificado = usuarioGitModificado;
		}
}
