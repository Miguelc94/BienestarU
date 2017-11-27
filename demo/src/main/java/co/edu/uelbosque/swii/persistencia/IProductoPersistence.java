package co.edu.uelbosque.swii.persistencia;

import java.util.List;

import co.edu.uelbosque.swii.entidades.Producto;

public interface IProductoPersistence {

	List<Producto> getProductos();
	Producto getProductoById(int productoId);
	boolean createProducto(Producto producto);
	void updateProducto(Producto producto);
	void deleteProducto(int productoId);
	List<Producto> productosDisponibles();
	List<Producto> productosPrestados();
}
