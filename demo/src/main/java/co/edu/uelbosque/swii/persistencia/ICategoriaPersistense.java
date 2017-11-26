package co.edu.uelbosque.swii.persistencia;

import java.util.List;
import co.edu.uelbosque.swii.entidades.Categoria;

public interface ICategoriaPersistense {
	List<Categoria> getCategorias();
	Categoria getCategoriaById(int categoriaId);
	boolean createCategoria(Categoria categoria);
	void updateCategoria(Categoria categoria);
	void deleteCategoria(int categoriaId);
}