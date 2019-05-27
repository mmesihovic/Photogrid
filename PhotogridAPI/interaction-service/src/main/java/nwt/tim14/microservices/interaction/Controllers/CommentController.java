package nwt.tim14.microservices.interaction.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nwt.tim14.microservices.interaction.DTOs.CommentDTO;
import nwt.tim14.microservices.interaction.DTOs.NotificationDTO;
import nwt.tim14.microservices.interaction.Entities.Comment;
import nwt.tim14.microservices.interaction.Entities.Post;
import nwt.tim14.microservices.interaction.Repositories.ICommentRepository;
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
public class CommentController {

    @Bean(name="restTemplate1")
    public RestTemplate restTemplate1() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8084));
        clientHttpRequestFactory.setProxy(proxy);

        return new RestTemplate(clientHttpRequestFactory);
    }

    @Autowired
    private RestTemplate restTemplate1;

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;


    @RequestMapping(value = "/testmq", method = RequestMethod.GET)
    public void testmq() {
        // ... do some database stuff
        String routingKey = "notification.document";
        String message = "{ \"message\": \"newcomment123!\"}";
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
    }

    @RequestMapping(value = "/interactions/comments", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @RequestMapping(value = "/interactions/comments", method = RequestMethod.POST)
    @ResponseBody
    public void addComment(@RequestBody Comment comment, final HttpServletResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        String routingKey = "notification.*";
        String message = null;
        try {
            //String url = "http://user-service/users/5";
            //Object[] userServiceResponse = restTemplate1.getForObject(url, Object[].class);

            Comment newComment = Comment.builder()
                    .content(comment.getContent())
                    .post(comment.getPost())
                    .userID(comment.getUserID())
                    .build();
            commentRepository.save(newComment);

            NotificationDTO notification = NotificationDTO.builder()
                    .type("NEWCOMMENT")
                    .postId(comment.getPost().getId())
                    .userId(comment.getUserID())
                    .build();
            message = mapper.writeValueAsString(notification);

            rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/interactions/comments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Comment getCommentById(@PathVariable Long id) {
        return commentRepository.findOne(id);
    }

    @RequestMapping(value = "/interactions/comments/{id}", method = RequestMethod.DELETE)
    public void deleteCommentById(@PathVariable Long id) {
        commentRepository.delete(id);
    }

    @RequestMapping(value = "/interactions/comments/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Comment updatePostById(@PathVariable Long id, @RequestBody Comment comment) {

        Comment newComment = commentRepository.findOne(id);

        newComment.setPost(comment.getPost());
        newComment.setContent(comment.getContent());
        newComment.setUserID(comment.getUserID());
        newComment.setReactions(comment.getReactions());
        newComment.setReactionsList(comment.getReactionsList());

        commentRepository.save(newComment);

        return newComment;
    }

}
