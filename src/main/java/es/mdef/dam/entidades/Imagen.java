package es.mdef.dam.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Imagen extends Recurso{
	  
    
	private Resolucion resolucion;
	public Resolucion getResolucion() {
		return resolucion;
	}
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	@Override
	public Tipo getTipo() {		
		return Tipo.video;
	}	
	@Override
	public Tipo setTipo() {		
		return Tipo.video;
	}
}