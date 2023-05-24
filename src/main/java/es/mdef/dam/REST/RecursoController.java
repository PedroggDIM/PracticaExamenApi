package es.mdef.dam.REST;
import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.dam.DamApplication;
import es.mdef.dam.entidades.Recurso;
import es.mdef.dam.repositorios.RecursoRepositorio;

@RestController
@RequestMapping("/recursos")
public class RecursoController {
	private final RecursoRepositorio repositorio;
	private final RecursoAssembler assembler;
	private final Logger log;

	RecursoController(RecursoRepositorio repositorio, RecursoAssembler assembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		log = DamApplication.log;
	}

	@GetMapping("{id}")
	public RecursoModel one(@PathVariable Long id) {
		Recurso recurso = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "recurso"));
		log.info("Recuperado " + recurso);
		return assembler.toModel(recurso);
	}

	@GetMapping
	public CollectionModel<RecursoModel> all() {
		return assembler.toCollectionModel(repositorio.findAll());
	}

	// Metodo para recuperara todos los recursos que tiene un usuario.
//	@GetMapping("{id}/usuarios")
//	public CollectionModel<UsuarioModel> recursosDeUsuario(@PathVariable Long id) {
//		Usuario usuario = repositorio.findById(id)
//				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
//	    return prListaAssembler.toCollection(usuario.getRecursos();
//	}

	@PostMapping
	// public RecursoModel add(@Valid @RequestBody RecursoModel model) {
	public RecursoModel add(@RequestBody RecursoModel model) {
		Recurso recurso = repositorio.save(assembler.toEntity(model));
		log.info("Añadido " + recurso);
		return assembler.toModel(recurso);
	}

	@PutMapping("{id}")
	public RecursoModel edit(@PathVariable Long id, @RequestBody RecursoModel model) {
		Recurso recurso = repositorio.findById(id).map(rec -> {
			rec.setFichero(model.getFichero());
			rec.setTamanio(model.getTamanio());
		    	return repositorio.save(rec);
		}).orElseThrow(() -> new RegisterNotFoundException(id, "recurso"));
		log.info("Actualizado " + recurso);
		return assembler.toModel(recurso);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado recurso " + id);
		repositorio.deleteById(id);
	}
}