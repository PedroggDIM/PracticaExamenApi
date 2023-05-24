package es.mdef.dam.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Video extends Recurso{
	
	private int duracion;	
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}	

}