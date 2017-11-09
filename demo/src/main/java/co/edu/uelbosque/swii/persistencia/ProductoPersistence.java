package co.edu.uelbosque.swii.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uelbosque.swii.entidades.Producto;

public interface ProductoPersistence extends JpaRepository<Producto, Long> {
	
}
