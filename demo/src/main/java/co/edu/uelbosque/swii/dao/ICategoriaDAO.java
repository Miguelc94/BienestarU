package co.edu.uelbosque.swii.dao;

import java.util.List;
import co.edu.uelbosque.swii.entidades.Categoria;

public interface ICategoriaDAO {
	List<Categoria> getCategorias();
	Categoria getCategoriaById(int catgeoriaId);
	void createCategoria(Categoria catgeoria);
	void updateCategoria(Categoria categoria);
	void deleteCategoria(int categoriaId);
	boolean categoriaExists(String nombre);
}
