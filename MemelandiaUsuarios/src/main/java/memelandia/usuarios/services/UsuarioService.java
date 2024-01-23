package memelandia.usuarios.services;

import memelandia.usuarios.core.Usuario;
import memelandia.usuarios.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    public Usuario insertUsuario(Usuario usuario) {
        Usuario usuarioRepository = repository.insert(usuario);
        LOGGER.info("Usuario '" + usuarioRepository.getId() + "' foi criado");
        return usuarioRepository;
    }

    public List<Usuario> findAll() {
        LOGGER.info("Consultou todos os usuarios");
        return repository.findAll();
    }

    public Optional<Usuario> findById(String id) {
        LOGGER.info("Consultou um usuario com id '" + id +"'");
        return repository.findById(id);
    }
}
