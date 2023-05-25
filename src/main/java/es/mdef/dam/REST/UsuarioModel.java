package es.mdef.dam.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.dam.support.Usuario.Role;

@Relation(itemRelation = "usuarioImpl")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	private String nombreUsuario;
	private Role rol;
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Role getRol() {
		return rol;
	}
	public void setRol(Role rol) {
		this.rol = rol;
	}
	
	
}
