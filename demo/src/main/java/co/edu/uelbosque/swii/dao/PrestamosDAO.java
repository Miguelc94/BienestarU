package co.edu.uelbosque.swii.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uelbosque.swii.entidades.Producto;
import co.edu.uelbosque.swii.entidades.Reporte;

@Transactional
@Repository
public class PrestamosDAO implements IPrestamosDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private ProductoDAO proDAO;
	
	@Override
	public void prestar(int idSolicitante, int idProducto) {
		Producto producto = proDAO.getProductoById(idProducto);
		producto.setEstado(false);
		proDAO.updateProducto(producto);
		Reporte reporte = new Reporte(null, idSolicitante, producto.getNombre(), new Date(), null);
		entityManager.persist(reporte);
	}

	@Override
	public void devolver(int idSolicitante, int idProducto) {
		Reporte reporte = new Reporte();
		Producto producto = proDAO.getProductoById(idProducto);
		producto.setEstado(true);
		proDAO.updateProducto(producto);
		String hql = "From Reporte as rep where rep.solicitante = ? and rep.nombre_producto = ?";
		reporte = (Reporte) entityManager.createQuery(hql).setParameter(1, idSolicitante).setParameter(2, idProducto).getSingleResult();
		reporte.setFechaDevolucion(new Date());
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reporte> getReporte() {
		String hql = "FROM Reporte";
		return (List<Reporte>) entityManager.createQuery(hql).getResultList();
	}
	
	public static void main(String [] args) {
		PrestamosDAO p = new PrestamosDAO();
		p.getReporte();
	}
	
}
