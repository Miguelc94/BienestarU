package co.edu.uelbosque.swii.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uelbosque.swii.entidades.Disponible;

public interface DisponiblePersistense extends JpaRepository<Disponible, Long> {

}
