package memelandia.memes.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationRabbitMQ {
    public static final String NAME_QUEUE = "memelandia-queue-memes";
    public static final String NAME_EXCHANGE = "memelandia-exchange-memes";
    public static final String NAME_ROUTE = "memelandia-route.memes";

    @Bean
    public Queue queue(){
        return new Queue(NAME_QUEUE, false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(NAME_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(NAME_ROUTE);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
