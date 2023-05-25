package es.mdef.dam.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.dam.support.Usuario.Role;

@Relation(itemRelation = "usuarioImpl")
public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{

	private String nombreUsuario;
	private String contrasenia;
	private Role rol;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Role getRol() {
		return rol;
	}
	public void setRol(Role rol) {
		this.rol = rol;
	}
	
	
}
