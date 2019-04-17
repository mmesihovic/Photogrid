package nwt.tim14.microservices.notification.Configuration;

import nwt.tim14.microservices.notification.Controllers.NotificationController;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {

    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("eventExchange");
    }

    /*@Bean
    public NotificationController notificationController(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
        return new NotificationController(rabbitTemplate, eventExchange);
    };*/
}
