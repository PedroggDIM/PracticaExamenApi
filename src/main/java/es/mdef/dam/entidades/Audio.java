package es.mdef.dam.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Audio extends Recurso{

	private int duracion;
	
	@Override
	public Tipo getTipo() {		
		return Tipo.audio;
	}	
	@Override
	public Tipo setTipo() {		
		return Tipo.audio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
}