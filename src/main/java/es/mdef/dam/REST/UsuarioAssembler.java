package es.mdef.dam.REST;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import es.mdef.dam.entidades.UsuarioImpl;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<UsuarioImpl, UsuarioModel>{

	@Override
	public UsuarioModel toModel(UsuarioImpl entity) {
		UsuarioModel model = new UsuarioModel();
		model.setNombreUsuario(entity.getNombreUsuario());		
		model.setRol(entity.getRole());		
		
		model.add(
			//	linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
			//	linkTo(methodOn(RecursoController.class).one(entity.getId())).withRel("usuario")
				 );
		
		return model;
	}
	public UsuarioImpl toEntity(UsuarioModel model) {
		UsuarioImpl usuario = new UsuarioImpl();
				
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setRole(model.getRol());
		
		return usuario;
	}
	
}