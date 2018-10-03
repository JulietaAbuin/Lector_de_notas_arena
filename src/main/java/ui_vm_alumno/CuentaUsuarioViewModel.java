package ui_vm_alumno;

import org.uqbar.commons.utils.Observable;

import conexion_http.Cliente;
import conexion_http.EstudianteToJson;
import modelo.Estudiante;
import modelo.RepoEstudiantes;

@Observable
public class CuentaUsuarioViewModel {

		public String nombreModificado;
		public String apellidoModificado;
		public String usuarioGitModificado;
		
		public String nombre;
		public String apellido;
		public String usuarioGit;
		
		public void aplicarModificacion(Estudiante estudiante) {
			nombre = estudiante.getNombre();
			apellido = estudiante.getApellido();
			usuarioGit = estudiante.getUsuariogit();
			Integer legajo = estudiante.getLegajo();
			if(nombreModificado!= "") {
				estudiante.setNombre(nombreModificado);
			}
			if(apellidoModificado!= "") {
				estudiante.setApellido(apellidoModificado);
			}
			if(usuarioGitModificado != "") {
				estudiante.setUsuariogit(usuarioGitModificado);
			}
			Cliente cliente = new Cliente();
			cliente.putEstudiante(EstudianteToJson.pasarAJson(legajo, nombre, apellido, usuarioGit));
		
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
	
		public String getUsuarioGit() {
			return usuarioGit;
		}
		public void setUsuarioGit(String usuarioGit) {
			this.usuarioGit = usuarioGit;
		}
}
