package es.mdef.dam.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RECURSOS")

// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
// @DiscriminatorColumn(name="tipo_recurso", discriminatorType = DiscriminatorType.CHAR)
// @DiscriminatorValue("null")
public class Recurso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String fichero;
	private int tamanio;
	
	public static enum Tipo {
		audio,
		imagen,
		video
	}
//Un Usuario puede tener muchos Recursos
	//	@ManyToOne(fetch = FetchType.LAZY)
	//	@JoinColumn(name = "idUsuario")
//	private Usuario usuario;
	
	
	// getter y setter
	public Tipo getTipo() {
		return null;
	}
	public Tipo setTipo() {
		return null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	

}