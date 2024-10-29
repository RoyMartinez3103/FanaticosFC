package mx.unam.dgtic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService <T, ID> {
    Page<T> listarTodos(Pageable pageable);
    T buscarPorId(ID id);
    void guardar(T entidad);
    void borrar(ID id);
    List<T> mostrar();
}
