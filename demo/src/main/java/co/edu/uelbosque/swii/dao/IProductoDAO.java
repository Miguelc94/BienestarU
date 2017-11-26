package co.edu.uelbosque.swii.dao;

import java.util.List;
import co.edu.uelbosque.swii.entidades.Producto;;

public interface IProductoDAO {

	List<Producto> getProductos();
	Producto getProductoById(int productoId);
	void createProducto(Producto producto);
	void updateProducto(Producto producto);
	void deleteProducto(int productoId);
	boolean productoExists(String nombre);
}
