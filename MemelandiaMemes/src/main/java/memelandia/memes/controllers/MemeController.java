package memelandia.memes.controllers;

import memelandia.memes.client.Categoria;
import memelandia.memes.client.Usuario;
import memelandia.memes.core.Meme;
import memelandia.memes.repositories.MemeRepository;
import memelandia.memes.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    private MemeService service;
    @Autowired
    private Usuario usuario;
    @Autowired
    private Categoria categoria;

    @PostMapping
    public Meme novoMeme(@RequestBody Meme meme) {
        System.out.println(usuario.FindById(meme.getIdUsuario()));
        System.out.println(categoria.FindById(meme.getIdCategoria()));
        return service.novoMeme(meme);
    }

    @GetMapping
    public List<Meme> findAll() {
        return service.findAll();
    }
}
