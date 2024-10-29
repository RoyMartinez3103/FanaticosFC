package mx.unam.dgtic.repository;

import mx.unam.dgtic.model.Deudor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeudorRepository extends JpaRepository<Deudor,Integer> {
}
