package ui_vm_alumno;

import org.uqbar.commons.utils.Observable;

import modelo.Estudiante;


@Observable
public class CuentaUsuarioViewModel {

		public String nombreModificado;
		public String apellidoModificado;
		public int legajoModificado;
		public String usuarioGitModificado;
		public String nombre;
		public String apellido;
		public int legajo;
		public String usuarioGit;
		
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
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public int getLegajo() {
			return legajo;
		}
		public void setLegajo(int legajo) {
			this.legajo = legajo;
		}
		public String getUsuarioGit() {
			return usuarioGit;
		}
		public void setUsuarioGit(String usuarioGit) {
			this.usuarioGit = usuarioGit;
		}
}
