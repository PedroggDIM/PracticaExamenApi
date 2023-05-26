package es.mdef.dam.REST;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import es.mdef.dam.entidades.UsuarioImpl;

@Component
public class UsuarioPostAsembler implements RepresentationModelAssembler<UsuarioImpl, UsuarioPostModel>{

	@Override
	public UsuarioPostModel toModel(UsuarioImpl entity) {
		UsuarioPostModel model = new UsuarioPostModel();
		model.setNombreUsuario(entity.getNombreUsuario());	
		model.setContrasenia(entity.getContrasenia());
		model.setRol(entity.getRole());
		
		
		model.add(
			//	linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
			//	linkTo(methodOn(RecursoController.class).one(entity.getId())).withRel("usuario")
				 );
		
		return model;
	}
	public UsuarioImpl toEntity(UsuarioPostModel model) {
		UsuarioImpl usuario = new UsuarioImpl();				
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setContrasenia(model.getContrasenia());
		usuario.setRole(model.getRol());		
		return usuario;
	}
	
}