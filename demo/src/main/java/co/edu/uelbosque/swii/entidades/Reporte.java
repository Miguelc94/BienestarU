package co.edu.uelbosque.swii.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="reportes")
public class Reporte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="solicitante")
	private Integer idSolicitante;
	@Column(name="nombre_producto")
	private String nomProducto;
	@Column(name="fecha_prestamo")
	private Date fechaPrestamo;
	@Column(name="fecha_devolucion")
	private Date fechaDevolucion;
	
	public Reporte() {
	}
	
	public Reporte(Integer id, Integer idSolicitante, String nomProducto,
			Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.id = id;
		this.idSolicitante = idSolicitante;
		this.nomProducto = nomProducto;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdSolicitante() {
		return idSolicitante;
	}
	public void setIdSolicitante(Integer idSolicitante) {
		this.idSolicitante = idSolicitante;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}	
}
