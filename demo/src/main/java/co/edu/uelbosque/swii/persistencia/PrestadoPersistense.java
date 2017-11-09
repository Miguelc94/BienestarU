package co.edu.uelbosque.swii.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uelbosque.swii.entidades.Prestado;

public interface PrestadoPersistense extends JpaRepository<Prestado, Long> {

}
