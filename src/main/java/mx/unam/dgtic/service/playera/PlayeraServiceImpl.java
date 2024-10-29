package mx.unam.dgtic.service.playera;

import mx.unam.dgtic.model.Playera;
import mx.unam.dgtic.repository.PlayeraRepository;
import mx.unam.dgtic.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlayeraServiceImpl implements GenericService<Playera,Integer> {
    
    @Autowired
    PlayeraRepository playeraRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Playera> listarTodos(Pageable pageable) {
        return playeraRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Playera buscarPorId(Integer id) {
        Optional<Playera> opPlayera = playeraRepository.findById(id);
        return opPlayera.orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Playera playera) {
        playeraRepository.save(playera);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        playeraRepository.deleteById(id);
    }

    @Override
    public List<Playera> mostrar() {
        return playeraRepository.findAll();
    }

}
