package nwt.tim14.microservices.interaction.Configuration;

import nwt.tim14.microservices.interaction.Controllers.CommentController;
import nwt.tim14.microservices.interaction.Controllers.ReactionController;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InteractionConfiguration {
    /*@Bean
    public Exchange eventExchange() {
        return new TopicExchange("eventExchange");
    }

    @Bean
    public CommentController commentController(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
        return new CommentController(rabbitTemplate, eventExchange);
    };

    @Bean
    public ReactionController reactionController(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
        return new ReactionController(rabbitTemplate, eventExchange);
    };

    @Bean
    public Queue queue() {
        return new Queue("testQueue");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange eventExchange) {
        return BindingBuilder
                .bind(queue)
                .to(eventExchange)
                .with("test.*");
    }

    @Bean
    public CommentController commentController() {
        return new CommentController();
    }*/

}
