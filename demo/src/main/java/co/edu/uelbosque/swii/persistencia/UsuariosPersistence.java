package co.edu.uelbosque.swii.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uelbosque.swii.entidades.Users;

@Repository
public interface UsuariosPersistence extends JpaRepository<Users, String> {

}
