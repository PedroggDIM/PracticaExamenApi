package es.mdef.dam.REST;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.dam.entidades.Recurso;
@Component
public class RecursoListaAssembler implements RepresentationModelAssembler<Recurso, RecursoListaModel>{

	@Override
	public RecursoListaModel toModel(Recurso entity) {
		RecursoListaModel model = new RecursoListaModel();
		model.setFichero(entity.getFichero());
		model.setTamanio(entity.getTamanio());
		model.setTipo(entity.getTipo());
		return model;
	}
	
	public CollectionModel<RecursoListaModel> toCollection(List<Recurso> recursos) { 
		return CollectionModel.of(
				recursos.stream().map(this::toModel).collect(Collectors.toList())
		);
	}

}
