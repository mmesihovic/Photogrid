package nwt.tim14.microservices.document.Configuration;

import nwt.tim14.microservices.document.Controllers.ApiController;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentConfiguration {
    @Bean
    public TopicExchange eventExchange() {
        return new TopicExchange("photogrid-exchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("documentQueue");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange eventExchange) {
        return BindingBuilder
                .bind(queue)
                .to(eventExchange)
                .with("document.*");
    }

}
