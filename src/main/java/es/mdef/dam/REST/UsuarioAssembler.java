package es.mdef.dam.REST;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import es.mdef.dam.entidades.UsuarioImpl;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<UsuarioImpl, UsuarioModel>{

	@Override
	public UsuarioModel toModel(UsuarioImpl entity) {
		UsuarioModel model = new UsuarioModel();
		model.setNombreUsuario(entity.getNombreUsuario());		
		model.setRol(entity.getRole());		
		
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
				,linkTo(methodOn(UsuarioController.class).recursosDeUsuario(entity.getId())).withRel("recursos")
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