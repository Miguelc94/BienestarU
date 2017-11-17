package co.edu.uelbosque.swii.entidades;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true) 
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Boolean estado;
	private Categoria categoria;

	public Producto() {
	}

	public Producto(String nombre, Boolean estado, Categoria categoria) {
		this.nombre = nombre;
		this.estado = estado;
		this.categoria = categoria;
	}

	public Producto(Long id, String nombre, Boolean estado, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.categoria = categoria;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}