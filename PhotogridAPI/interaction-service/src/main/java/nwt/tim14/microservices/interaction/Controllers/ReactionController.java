package nwt.tim14.microservices.interaction.Controllers;

import nwt.tim14.microservices.interaction.Entities.Reaction;
import nwt.tim14.microservices.interaction.Repositories.IReactionRepository;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.net.InetSocketAddress;
import java.net.Proxy;

@RestController
public class ReactionController {

    @Bean(name="restTemplate2")
    public RestTemplate restTemplate2() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8084));
        clientHttpRequestFactory.setProxy(proxy);

        return new RestTemplate(clientHttpRequestFactory);
    }

    @Autowired
    private RestTemplate restTemplate2;

    @Autowired
    private IReactionRepository reactionRepository;

    /*private final RabbitTemplate rabbitTemplate;

    private final Exchange exchange;

    public ReactionController(RabbitTemplate rabbitTemplate, Exchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    @RequestMapping(value = "/testmq", method = RequestMethod.GET)
    public void testmq() {
        // ... do some database stuff
        String routingKey = "test.test";
        String message = "test";
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
    }*/

    @RequestMapping(value = "/interactions/reactions", method = RequestMethod.GET)
    public Iterable<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

    @RequestMapping(value = "/interactions/reactions", method = RequestMethod.POST)
    @ResponseBody
    public void addReaction(@RequestBody Reaction reaction, final HttpServletResponse response) {
        String url = "http://user-service/users/5";
        Object[] userServiceResponse = restTemplate2.getForObject(url, Object[].class);
        if (userServiceResponse == null) {
            try {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("User sa navedenim ID-om ne postoji.");
                response.getWriter().flush();
                return;
            }
            catch (Exception e) {
                // Who Cares
            }
        }
        reactionRepository.save(reaction);
    }

    @RequestMapping(value = "/interactions/reactions/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reaction getReactionById(@PathVariable Long id) {
        return reactionRepository.findOne(id);
    }

    @RequestMapping(value = "/interactions/reactions/{id}", method = RequestMethod.DELETE)
    public void deleteReactionById(@PathVariable Long id) {
        reactionRepository.delete(id);
    }

    @RequestMapping(value = "/interactions/reactions/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Reaction updateReaction(@PathVariable Long id, @RequestBody Reaction reaction) {

        Reaction newReaction = reactionRepository.findOne(id);

        newReaction.setType(reaction.getType());
        newReaction.setComments(reaction.getComments());
        newReaction.setPosts(reaction.getPosts());

        reactionRepository.save(newReaction);

        return newReaction;
    }

}
