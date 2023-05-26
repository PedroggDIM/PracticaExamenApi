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
import es.mdef.dam.entidades.Audio;
import es.mdef.dam.entidades.Imagen;
import es.mdef.dam.entidades.Recurso;
import es.mdef.dam.entidades.UsuarioImpl;
import es.mdef.dam.entidades.Video;
import es.mdef.dam.entidades.Recurso.Tipo;
import es.mdef.dam.repositorios.RecursoRepositorio;

@RestController
@RequestMapping("/recursos")
public class RecursoController {
	private final RecursoRepositorio repositorio;
	private final RecursoAssembler assembler;
	private final UsuarioAssembler usuarioAssembler;
	private final Logger log;

	RecursoController(RecursoRepositorio repositorio, RecursoAssembler assembler, UsuarioAssembler usuarioAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.usuarioAssembler = usuarioAssembler;
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

//	 Metodo para recuperara todos los recursos que tiene un usuario.
	@GetMapping("{id}/usuario")
	public UsuarioModel usuarioRecurso(@PathVariable Long id) {
		Recurso recurso = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		UsuarioImpl usuario = recurso.getUsuario();
	    return usuarioAssembler.toModel(usuario);
	}

	@PostMapping	
	public RecursoModel add(@RequestBody RecursoModel model) {
		Recurso recurso = repositorio.save(assembler.toEntity(model));
		log.info("Añadido " + recurso);
		return assembler.toModel(recurso);
	}

	@PutMapping("{id}")
	public RecursoModel edit(@PathVariable Long id, @RequestBody RecursoModel model) {
		Recurso recurso = repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id, "recurso"));
		log.info("Actualizado " + recurso);
		recurso.setFichero(model.getFichero());
		recurso.setTamanio(model.getTamanio());
		if(model.getTipo() == Tipo.video) {
			Video video = (Video) recurso;
			video.setDuracion(model.getDuracion());
			video.setResolucion(model.getResolucion());
		}else if(model.getTipo() == Tipo.imagen ){
			Imagen imagen = (Imagen) recurso;
			imagen.setResolucion(model.getResolucion());
		}else if(model.getTipo() == Tipo.audio) {
			Audio audio = (Audio) recurso;
			audio.setDuracion(model.getDuracion());
		}
		return assembler.toModel(repositorio.save(recurso));
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado recurso " + id);
		repositorio.deleteById(id);
	}
}