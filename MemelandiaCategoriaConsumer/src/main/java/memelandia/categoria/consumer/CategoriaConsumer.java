package memelandia.categoria.consumer;

import memelandia.categoria.configuration.ConfigurationRabbitMQ;
import memelandia.categoria.core.Categoria;
import memelandia.categoria.services.CategoriaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConsumer {

    @Autowired
    private CategoriaService service;

    @RabbitListener(queues = ConfigurationRabbitMQ.NAME_QUEUE)
    public void receiveMessage(@Payload Categoria categoria){
        System.out.println("--------------------------");
        System.out.println("Recebendo: " + categoria );
        System.out.println("--------------------------");
        service.novaCategoria(categoria);
    }
}
