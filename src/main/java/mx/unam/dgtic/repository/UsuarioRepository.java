package mx.unam.dgtic.repository;

import mx.unam.dgtic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}

