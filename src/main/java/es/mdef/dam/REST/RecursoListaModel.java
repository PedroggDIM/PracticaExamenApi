package es.mdef.dam.REST;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.dam.entidades.Recurso.Tipo;

@Relation(collectionRelation = "recursos")
public class RecursoListaModel extends RepresentationModel<RecursoListaModel>{
	private String fichero;
	private int tamanio;
	private Tipo tipo;
	
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
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
