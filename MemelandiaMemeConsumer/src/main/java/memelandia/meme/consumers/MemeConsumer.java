package memelandia.meme.consumers;

import memelandia.meme.configuration.ConfigurationRabbitMQ;
import memelandia.meme.core.Meme;
import memelandia.meme.services.MemeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MemeConsumer {

    @Autowired
    private MemeService service;

    @RabbitListener(queues = ConfigurationRabbitMQ.NAME_QUEUE)
    public void receiveMessage(@Payload Meme meme){
        System.out.println("--------------------------");
        System.out.println("Recebendo: " + meme );
        System.out.println("--------------------------");
        service.novoMeme(meme);
    }
}

