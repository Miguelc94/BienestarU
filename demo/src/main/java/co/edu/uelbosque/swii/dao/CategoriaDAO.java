package co.edu.uelbosque.swii.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.edu.uelbosque.swii.entidades.Categoria;

@Transactional
@Repository
public class CategoriaDAO implements ICategoriaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Categoria getCategoriaById(int categoriaId) {
		return entityManager.find(Categoria.class, categoriaId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> getCategorias() {
		String hql = "FROM Categoria";
		return (List<Categoria>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void createCategoria(Categoria categoria) {
		entityManager.persist(categoria);
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		Categoria cat = getCategoriaById(categoria.getId());
		cat.setNombre(categoria.getNombre());
		entityManager.flush();
		
	}

	@Override
	public void deleteCategoria(int categoriaId) {
		entityManager.remove(getCategoriaById(categoriaId));
	}

	@Override
	public boolean categoriaExists(String nombre) {
		String hql = "FROM Categoria as cat WHERE cat.nombre = ?";
		int count = entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		return count > 0 ? true: false;
	}

}
