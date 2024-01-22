package memelandia.usuarios.services;

import memelandia.usuarios.core.Usuario;
import memelandia.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario insertUsuario(Usuario usuario) {
        return repository.insert(usuario);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(String id) {
        return repository.findById(id);
    }
}
