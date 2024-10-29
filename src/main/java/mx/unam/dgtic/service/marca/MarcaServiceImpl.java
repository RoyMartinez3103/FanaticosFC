package mx.unam.dgtic.service.marca;

import mx.unam.dgtic.model.Marca;
import mx.unam.dgtic.repository.MarcaRepository;
import mx.unam.dgtic.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MarcaServiceImpl implements GenericService<Marca,Integer> {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Marca> listarTodos(Pageable pageable) {
        return marcaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Marca buscarPorId(Integer id) {
        Optional<Marca> opMarca = marcaRepository.findById(id);
        return opMarca.orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        marcaRepository.deleteById(id);
    }
}
