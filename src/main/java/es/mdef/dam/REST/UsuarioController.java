package es.mdef.dam.REST;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.mdef.dam.DamApplication;
import es.mdef.dam.entidades.UsuarioImpl;
import es.mdef.dam.repositorios.UsuarioRepositorio;


@RestController
@RequestMapping("/recursos")
public class UsuarioController {
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;
    private final UsuarioPostAsembler postassembler;
    //Relación 1 a N con recursos (uno a muchos)
	private final RecursoAssembler recursoAssembler;
	private final Logger log;

	UsuarioController(UsuarioRepositorio repositorio, UsuarioAssembler assembler,
			RecursoAssembler recursoAssembler, UsuarioPostAsembler postassembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
	    this.postassembler = postassembler;
		this.recursoAssembler = recursoAssembler;
		log = DamApplication.log;
	}

//	@GetMapping("{id}")
//	public UsuarioModel one(@PathVariable Long id) {
//		UsuarioImpl usuario = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
//		log.info("Recuperado " + usuario);
//		return assembler.toModel(usuario);
//	}
//
//	@GetMapping()
//	public CollectionModel<UsuarioModel> all() {
//		return assembler.toCollectionModel(repositorio.findAll());
//	}

	// Metodo para recuperara todos los recursos que tiene un usuario.
//	@GetMapping("{id}/recursos")
//	public CollectionModel<UsuarioModel> recursosDeUsuario(@PathVariable Long id) {
//		UsuarioImpl usuario = repositorio.findById(id)
//				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
//	    return prListaAssembler.toCollection(usuario.getRecursos();
//	}

//	@PostMapping
//	public UsuarioModel add(@RequestBody UsuarioModel model) {
//		UsuarioImpl usuario = repositorio.save(assembler.toEntity(model));
//		log.info("Añadido " + usuario);
//		return assembler.toModel(usuario);
//	}

//	@PutMapping("{id}")
//	public UsuarioModel edit(@PathVariable Long id, @RequestBody UsuarioPostModel model) {
//		UsuarioImpl usuario = repositorio.findById(id).map(rec -> {
//			rec.setNombreUsuario(model.getNombreUsuario());
//		    rec.setContrasenia(model.getContrasenia());
//			rec.setRole(model.getRol());
//		    	return repositorio.save(rec);
//		}).orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
//		log.info("Actualizado " + usuario);
//		return assembler.toModel(usuario);
//	}

//	@DeleteMapping("{id}")
//	public void delete(@PathVariable Long id) {
//		log.info("Borrado recurso " + id);
//		repositorio.deleteById(id);
//	}
}