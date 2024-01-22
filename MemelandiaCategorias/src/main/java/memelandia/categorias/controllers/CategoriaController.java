package memelandia.categorias.controllers;

import memelandia.categorias.client.Usuario;
import memelandia.categorias.core.Categoria;
import memelandia.categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;
    @Autowired
    private Usuario usuario;

    @PostMapping
    public Categoria novaCategoriaMeme(Categoria categoria) {
        System.out.println(usuario.FindById(categoria.getIdUsuario()));
        return service.novaCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> findById(@PathVariable String id) {
        return service.findById(id);
    }
}
