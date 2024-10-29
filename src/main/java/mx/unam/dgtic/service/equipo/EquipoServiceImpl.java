package mx.unam.dgtic.service.equipo;

import mx.unam.dgtic.model.Equipo;
import mx.unam.dgtic.repository.EquipoRepository;
import mx.unam.dgtic.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements GenericService<Equipo,Integer> {

    @Autowired
    EquipoRepository equipoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Equipo> listarTodos(Pageable pageable) {
        return equipoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Equipo buscarPorId(Integer id) {
        Optional<Equipo> opEquipo = equipoRepository.findById(id);
        return opEquipo.orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public List<Equipo> mostrar() {
        return equipoRepository.findAll();
    }


}
