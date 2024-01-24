package memelandia.memes.services;

import memelandia.memes.client.Client;
import memelandia.memes.configuration.ConfigurationRabbitMQ;
import memelandia.memes.core.Meme;
import memelandia.memes.repositories.MemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {

    @Autowired
    private MemeRepository repository;
    @Autowired
    private Client client;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemeService.class);

    public Meme novoMeme(Meme meme) {
        if(!client.FindByIdUsuario(meme.getIdUsuario())){
            LOGGER.info("Usuario invalido: '" + meme.getIdUsuario() + "' tentou criar um meme");
            return null;
        }
        else if(!client.FindByIdCategoria(meme.getIdCategoria())){
            LOGGER.info("Usuario '" + meme.getIdUsuario() + "' tentou criar um meme com categoria invalida: '" + meme.getIdCategoria() + "'");
            return null;
        }else {
            //Meme memeRepository = repository.insert(meme);
            rabbitTemplate.convertAndSend(ConfigurationRabbitMQ.NAME_EXCHANGE, ConfigurationRabbitMQ.NAME_ROUTE, meme);
            LOGGER.info("Meme '" + meme.getId() + "' criado por usuario '" + meme.getIdUsuario() + "' na categoria '" + meme.getIdCategoria() +"'");
            return meme;
        }
    }

    public List<Meme> findAll() {
        LOGGER.info("Consultou todos os memes");
        return repository.findAll();
    }
}
