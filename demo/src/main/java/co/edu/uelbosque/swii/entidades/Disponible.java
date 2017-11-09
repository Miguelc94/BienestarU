package co.edu.uelbosque.swii.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="disponibles")
public class Disponible {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long codigoCategoria;
	
	public Disponible() {}
	
	public Disponible(String producto, long categoria) {
		this.nombre = producto;
		this.codigoCategoria = categoria;
	}
	
	public Disponible(long i, String producto, long categoria) {
		this.id = i;
		this.nombre = producto;
		this.codigoCategoria = categoria;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
}
