package es.mdef.dam.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import es.mdef.dam.entidades.UsuarioImpl;


public interface UsuarioRepositorio extends JpaRepository<UsuarioImpl, Long>{
	
}
