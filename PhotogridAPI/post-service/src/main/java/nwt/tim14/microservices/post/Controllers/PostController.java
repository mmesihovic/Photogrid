package nwt.tim14.microservices.post.Controllers;

import nwt.tim14.microservices.post.Entities.Post;
import nwt.tim14.microservices.post.Repositories.IPostRepository;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.net.InetSocketAddress;
import java.net.Proxy;

@RestController
public class PostController {

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8084));
        clientHttpRequestFactory.setProxy(proxy);

        return new RestTemplate(clientHttpRequestFactory);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IPostRepository postRepository;

    /*private final RabbitTemplate rabbitTemplate;

    private final Exchange exchange;

    public PostController(RabbitTemplate rabbitTemplate, Exchange exchange) {
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

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseBody
    public void addPost(@RequestBody Post post, final HttpServletResponse response) {
        System.out.print(post);
        String url = "http://user-service/users/5";
        Object[] userServiceResponse = restTemplate.getForObject(url, Object[].class);
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
        postRepository.save(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findOne(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postRepository.delete(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {

        Post newPost = postRepository.findOne(id);

        newPost.setDecription(post.getDecription());
        newPost.setTags(post.getTags());
        newPost.setUserID(post.getUserID());

        postRepository.save(newPost);

        return newPost;
    }
}
