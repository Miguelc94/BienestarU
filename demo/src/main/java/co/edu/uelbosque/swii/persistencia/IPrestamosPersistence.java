package co.edu.uelbosque.swii.persistencia;

import java.util.List;

import co.edu.uelbosque.swii.entidades.Reporte;

public interface IPrestamosPersistence {
	List<Reporte> getReportes();
	public void prestar(int idSolicitante, int idProducto);
	public void devolver(int idSolicitante, int idProducto);
}
