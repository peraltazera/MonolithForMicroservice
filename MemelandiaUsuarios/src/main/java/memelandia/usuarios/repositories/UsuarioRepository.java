package memelandia.usuarios.repositories;

import memelandia.usuarios.core.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
