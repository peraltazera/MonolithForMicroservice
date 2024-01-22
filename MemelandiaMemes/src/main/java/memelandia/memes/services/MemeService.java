package memelandia.memes.services;

import memelandia.memes.core.Meme;
import memelandia.memes.repositories.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {

    @Autowired
    private MemeRepository repository;

    public Meme novoMeme(Meme meme) {
        return repository.insert(meme);
    }

    public List<Meme> findAll() {
        return repository.findAll();
    }
}
