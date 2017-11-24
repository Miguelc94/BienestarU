package co.edu.uelbosque.swii.persistencia;

import java.util.List;
import co.edu.uelbosque.swii.entidades.Categoria;

public interface ICategoriaPersistense {
	List<Categoria> getCategorias();
	Categoria getCategoriaById(int catgeoriaId);
	boolean createCategoria(Categoria catgeoria);
	void updateCategoria(Categoria categoria);
	void deleteCategoria(int categoriaId);
}