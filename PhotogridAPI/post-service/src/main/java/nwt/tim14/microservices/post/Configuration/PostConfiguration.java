package nwt.tim14.microservices.post.Configuration;

import nwt.tim14.microservices.post.Controllers.PostController;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfiguration {
    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("eventExchange");
    }

    /*@Bean
    public PostController postController(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
        return new PostController(rabbitTemplate, eventExchange);
    };*/
}
