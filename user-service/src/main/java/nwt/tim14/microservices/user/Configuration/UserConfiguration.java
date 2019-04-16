package nwt.tim14.microservices.user.Configuration;

import nwt.tim14.microservices.user.Controllers.UserController;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("eventExchange");
    }

    @Bean
    public UserController userController(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
        return new UserController(rabbitTemplate, eventExchange);
    }

}

