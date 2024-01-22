package memelandia.categorias.services;

import memelandia.categorias.core.Categoria;
import memelandia.categorias.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria novaCategoria(Categoria categoria) {
        return repository.insert(categoria);
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }
}
