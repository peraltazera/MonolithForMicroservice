package memelandia.usuario.consumer;

import memelandia.usuario.configuration.ConfigurationRabbitMQ;
import memelandia.usuario.core.Usuario;
import memelandia.usuario.services.UsuarioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConsumer {

    @Autowired
    private UsuarioService service;

    @RabbitListener(queues = ConfigurationRabbitMQ.NAME_QUEUE)
    public void receiveMessage(@Payload Usuario usuario){
        System.out.println("--------------------------");
        System.out.println("Recebendo: " + usuario );
        System.out.println("--------------------------");
        service.insertUsuario(usuario);
    }
}
