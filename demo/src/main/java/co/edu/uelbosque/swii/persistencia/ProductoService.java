package co.edu.uelbosque.swii.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uelbosque.swii.dao.IProductoDAO;
import co.edu.uelbosque.swii.entidades.Producto;

@Service
public class ProductoService implements IProductoPersistence {
	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	public Producto getProductoById(int productoId) {
		Producto obj = productoDAO.getProductoById(productoId);
		return obj;
	}
	
	@Override
	public List<Producto> getProductos() {
		return productoDAO.getProductos();
	}

	@Override
	public synchronized boolean createProducto(Producto producto) {
		if (productoDAO.productoExists(producto.getNombre())) {
			return false;
		} else{
			productoDAO.createProducto(producto);
			return true;
		}
	}

	@Override
	public void updateProducto(Producto producto) {
		productoDAO.updateProducto(producto);
	}

	@Override
	public void deleteProducto(int productoId) {
		productoDAO.deleteProducto(productoId);	
	}
}
