package es.mdef.dam.entidades;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class UsuarioImpl extends es.mdef.dam.support.Usuario{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
    //En usuario una lista de Recursos 
	// Un usuario puede tener muchos recursos
	@OneToMany(mappedBy = "usuario")
	private List<Recurso> recursos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	@Override
	public String getContrasenia() {
		// TODO Auto-generated method stub
		return super.getContrasenia();
	}

	@Override
	public String getNombreUsuario() {
		// TODO Auto-generated method stub
		return super.getNombreUsuario();
	}

	@Override
	public Role getRole() {
		// TODO Auto-generated method stub
		return super.getRole();
	}

	@Override
	public void setContrasenia(String contrasenia) {
		// TODO Auto-generated method stub
		super.setContrasenia(contrasenia);
	}

	@Override
	public void setNombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		super.setNombreUsuario(nombreUsuario);
	}

	@Override
	public void setRole(Role role) {
		// TODO Auto-generated method stub
		super.setRole(role);
	}
	
	
	
}