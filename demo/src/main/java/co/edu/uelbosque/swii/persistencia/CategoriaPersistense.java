package co.edu.uelbosque.swii.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uelbosque.swii.entidades.Categoria;

public interface CategoriaPersistense extends JpaRepository<Categoria, Long> {

}
