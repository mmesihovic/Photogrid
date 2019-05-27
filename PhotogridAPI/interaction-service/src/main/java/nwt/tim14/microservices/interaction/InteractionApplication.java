package nwt.tim14.microservices.interaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InteractionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractionApplication.class, args);
    }

}
