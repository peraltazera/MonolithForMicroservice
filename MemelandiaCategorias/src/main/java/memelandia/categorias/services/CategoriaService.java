package memelandia.categorias.services;

import memelandia.categorias.client.Client;
import memelandia.categorias.core.Categoria;
import memelandia.categorias.repositories.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);

    public Categoria novaCategoria(Categoria categoria) {
        if(!client.FindByIdUsuario(categoria.getIdUsuario())){
            LOGGER.info("Usuario invalido: '" + categoria.getIdUsuario() + "' tentou criar uma categoria");
            return null;
        }else {
            Categoria categoriaRepository = repository.insert(categoria);
            LOGGER.info("Categoria '" + categoriaRepository.getId() + "' criada por usuario '" + categoria.getIdUsuario() + "'");
            return categoriaRepository;
        }
    }

    public List<Categoria> findAll() {
        LOGGER.info("Consultou todas as categorias");
        return repository.findAll();
    }

    public Optional<Categoria> findById(String id) {
        LOGGER.info("Consultou uma categoria com id '" + id +"'");
        return repository.findById(id);
    }
}
