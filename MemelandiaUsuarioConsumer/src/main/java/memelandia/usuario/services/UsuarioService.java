package memelandia.usuario.services;

import memelandia.usuario.core.Usuario;
import memelandia.usuario.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
