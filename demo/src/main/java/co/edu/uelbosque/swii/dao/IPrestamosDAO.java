package co.edu.uelbosque.swii.dao;

import java.util.List;

import co.edu.uelbosque.swii.entidades.Reporte;

public interface IPrestamosDAO {
	List<Reporte> getReporte();
	public void prestar(int idSolicitante, int idProducto);
	public void devolver(int idSolicitante, int idProducto);
}
