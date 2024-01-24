package memelandia.categoria.services;

import memelandia.categoria.core.Categoria;
import memelandia.categoria.repositories.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);

    public Categoria novaCategoria(Categoria categoria) {
        Categoria categoriaRepository = repository.insert(categoria);
        LOGGER.info("Categoria '" + categoria.getId() + "' criada por usuario '" + categoria.getIdUsuario() + "'");
        return categoria;
    }
}
