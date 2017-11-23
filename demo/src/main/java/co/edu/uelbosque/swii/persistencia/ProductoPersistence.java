package co.edu.uelbosque.swii.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uelbosque.swii.entidades.Producto;

@Repository
public interface ProductoPersistence extends JpaRepository<Producto, Long> {
	
}
