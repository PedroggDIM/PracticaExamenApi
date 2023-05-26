package es.mdef.dam.REST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.dam.entidades.Recurso;
import es.mdef.dam.entidades.Recurso.Tipo;
import es.mdef.dam.entidades.Video;
import es.mdef.dam.entidades.Audio;
import es.mdef.dam.entidades.Imagen;

@Component
public class RecursoAssembler implements RepresentationModelAssembler<Recurso, RecursoModel>{

	@Override
	public RecursoModel toModel(Recurso entity) {
		RecursoModel model = new RecursoModel();
		//campos comunes (los del padre)
		model.setFichero(entity.getFichero());
		model.setTamanio(entity.getTamanio());
		model.setUsuario(entity.getUsuario());
		
		if(entity instanceof Video) {
			Video video = (Video) entity;
			model.setDuracion(video.getDuracion());
			model.setResolucion(video.getResolucion());
			model.setTipo(Tipo.video);
		}else if(entity.getTipo() == Tipo.imagen ){
			Imagen imagen = (Imagen) entity;
			model.setResolucion(imagen.getResolucion());			
			model.setTipo(Tipo.imagen);
		}else if(entity.getTipo() == Tipo.audio) {
			Audio audio = (Audio) entity;
			model.setDuracion(audio.getDuracion());
			model.setTipo(Tipo.audio);
		}			
		model.add(
				linkTo(methodOn(RecursoController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withRel("usuario")
						);
		return model;
	}
	
	public Recurso toEntity(RecursoModel model) {
		Recurso recurso = new Recurso();
		
		if(model.getTipo() == Tipo.video) {
			Video video = new Video();
			video.setDuracion(model.getDuracion());
			video.setResolucion(model.getResolucion());	
			recurso = video;
		}else if(model.getTipo() == Tipo.imagen ){
			Imagen imagen = new Imagen();
			imagen.setResolucion(model.getResolucion());	
			recurso = imagen;
		}else if(model.getTipo() == Tipo.audio) {
			Audio audio = new Audio();
			audio.setDuracion(model.getDuracion());
			recurso = audio;
		}
		// campos comunes.
		recurso.setFichero(model.getFichero());
		recurso.setTamanio(model.getTamanio());	
		recurso.setUsuario(model.getUsuario());
		return recurso;
	}
}