package nwt.tim14.microservices.user.Configuration;

import nwt.tim14.microservices.user.Controllers.UserController;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("photogrid-exchange");
    }


    @Bean
    public Queue notificationQueue() {
        return new Queue("notificationQueue");
    }

    @Bean
    public Binding binding(Queue queue, Exchange eventExchange) {
        return BindingBuilder
                .bind(queue)
                .to((TopicExchange) eventExchange)
                .with("notification.*");
    }
}

