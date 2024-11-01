package mx.unam.dgtic.service.usuario;

import mx.unam.dgtic.model.Usuario;
import mx.unam.dgtic.repository.UsuarioRepository;
import mx.unam.dgtic.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements GenericService<Usuario,Integer> {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> listarTodos(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> opUsuario = usuarioRepository.findById(id);
        return opUsuario.orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> mostrar() {
        return List.of();
    }
}

