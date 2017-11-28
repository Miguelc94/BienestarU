package co.edu.uelbosque.swii.persistencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uelbosque.swii.dao.IPrestamosDAO;
import co.edu.uelbosque.swii.entidades.Reporte;

@Service
public class PrestamosServices implements IPrestamosPersistence {
	@Autowired
	private IPrestamosDAO prestamoDAO;
	
	@Override
	public void prestar(int idSolicitante, int idProducto) {
		prestamoDAO.prestar(idSolicitante, idProducto);
	}

	@Override
	public void devolver(int idSolicitante, int idProducto) {
		prestamoDAO.devolver(idSolicitante, idProducto);
	}

	@Override
	public List<Reporte> getReportes() {
		return prestamoDAO.getReporte();
	}
}

