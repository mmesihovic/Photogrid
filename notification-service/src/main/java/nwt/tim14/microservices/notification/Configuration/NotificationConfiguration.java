package nwt.tim14.microservices.notification.Configuration;

import nwt.tim14.microservices.notification.Controllers.NotificationController;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {

    @Bean
    Queue notificationQueue() {
        return new Queue("notificationQueue");
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange("photogrid-exchange");
    }

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to((TopicExchange) exchange).with("notification.*");
    }

}
