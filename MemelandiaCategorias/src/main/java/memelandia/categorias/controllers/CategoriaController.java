package memelandia.categorias.controllers;

import memelandia.categorias.core.Categoria;
import memelandia.categorias.repositories.CategoriaRepository;
import memelandia.categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public Categoria novaCategoriaMeme(Categoria categoria) {
        return service.novaCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> findAll() {
        return service.findAll();
    }
}
