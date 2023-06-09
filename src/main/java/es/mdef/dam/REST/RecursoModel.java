package es.mdef.dam.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.mdef.dam.entidades.Resolucion;
import es.mdef.dam.entidades.UsuarioImpl;
import es.mdef.dam.entidades.Recurso.Tipo;

@Relation(itemRelation = "recurso")
public class RecursoModel extends RepresentationModel<RecursoModel>{
	 
	private String fichero;
	private int tamanio;
	private int duracion;	
	private Resolucion resolucion;
    private Tipo tipo;
    
<<<<<<< HEAD
    private UsuarioImpl usuario;
    
    public UsuarioImpl getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioImpl usuario) {
		this.usuario = usuario;
	}
=======
>>>>>>> 429bec97990d1d2bdafb43ae023eed2795d470f8
	//getter setter
	public String getFichero() {
		return fichero;
	}
	public void setFichero(String fichero) {
		this.fichero = fichero;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Resolucion getResolucion() {
		return resolucion;
	}
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}