package memelandia.meme.services;

import memelandia.meme.core.Meme;
import memelandia.meme.repositories.MemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

    @Autowired
    private MemeRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemeService.class);

    public Meme novoMeme(Meme meme) {
        Meme memeRepository = repository.insert(meme);
        LOGGER.info("Meme '" + memeRepository.getId() + "' criado por usuario '" + meme.getIdUsuario() + "' na categoria '" + meme.getIdCategoria() + "'");
        return memeRepository;
    }
}
