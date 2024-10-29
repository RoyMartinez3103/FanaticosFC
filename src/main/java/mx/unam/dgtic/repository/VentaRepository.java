package mx.unam.dgtic.repository;

import mx.unam.dgtic.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
