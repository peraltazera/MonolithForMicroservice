package memelandia.memes.controllers;

import memelandia.memes.core.Meme;
import memelandia.memes.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    private MemeService service;

    @PostMapping
    public Meme novoMeme(@RequestBody Meme meme) {
        return service.novoMeme(meme);
    }

    @GetMapping
    public List<Meme> findAll() {
        return service.findAll();
    }
}
