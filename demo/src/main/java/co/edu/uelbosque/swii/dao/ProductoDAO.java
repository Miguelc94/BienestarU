package co.edu.uelbosque.swii.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.edu.uelbosque.swii.entidades.Producto;;

@Transactional
@Repository
public class ProductoDAO implements IProductoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Producto getProductoById(int productoId) {
		return entityManager.find(Producto.class, productoId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getProductos() {
		String hql = "FROM Producto";
		return (List<Producto>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void createProducto(Producto producto) {
		entityManager.persist(producto);
	}

	@Override
	public void updateProducto(Producto producto) {
		Producto pro = getProductoById(producto.getId());
		pro.setNombre(producto.getNombre());
		entityManager.flush();		
	}

	@Override
	public void deleteProducto(int productoId) {
		entityManager.remove(getProductoById(productoId));
	}

	@Override
	public boolean productoExists(String nombre) {
		String hql ="From Producto as pro Where pro.nombre = ?";
		int count = entityManager.createQuery(hql).setParameter(1,  nombre).getResultList().size();
		return count > 0 ? true: false;
	}	
}
