package co.edu.uelbosque.swii.persistencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uelbosque.swii.dao.ICategoriaDAO;
import co.edu.uelbosque.swii.entidades.Categoria;

@Service
public class CategoriaService implements ICategoriaPersistense {
	@Autowired
	private ICategoriaDAO categoriaDAO;

	@Override
	public Categoria getCategoriaById(int categoriaId) {
		Categoria obj = categoriaDAO.getCategoriaById(categoriaId);
		return obj;
	}

	@Override
	public List<Categoria> getCategorias() {
		return categoriaDAO.getCategorias();
	}

	@Override
	public synchronized boolean createCategoria(Categoria categoria) {
		if (categoriaDAO.categoriaExists(categoria.getNombre())) {
			return false;
		} else {
			categoriaDAO.createCategoria(categoria);
			return true;
		}
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		categoriaDAO.updateCategoria(categoria);
	}

	@Override
	public void deleteCategoria(int categoriaId) {
		categoriaDAO.deleteCategoria(categoriaId);
	}
}
