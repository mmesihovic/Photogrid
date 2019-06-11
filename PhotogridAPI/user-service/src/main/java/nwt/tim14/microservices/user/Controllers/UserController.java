package nwt.tim14.microservices.user.Controllers;


import nwt.tim14.microservices.user.DTOs.UserResponse;
import nwt.tim14.microservices.user.Entities.User;
import nwt.tim14.microservices.user.Repositories.RoleRepository;
import nwt.tim14.microservices.user.Repositories.UserRepository;
import org.aspectj.weaver.reflect.ArgNameFinder;
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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController  {
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8090));
        clientHttpRequestFactory.setProxy(proxy);

        return new RestTemplate(clientHttpRequestFactory);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/testmq", method = RequestMethod.GET)
    public void testmq() {
        // ... do some database stuff
        String routingKey = "test.test";
        String message = "test";
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user) {
        System.out.print(user);
        userRepository.save(user);
    }

    @RequestMapping(value = "/users/username/{username}", method = RequestMethod.GET)
    @ResponseBody
    public UserResponse getUserByUsername(@PathVariable String username, final HttpServletResponse response) {
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> { throw new IllegalArgumentException("User not found"); });

            return UserResponse.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .id(user.getId())
                    .roles(user.roles.stream().map(ur -> ur.getName()).collect(Collectors.toList()))
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .build();

        } catch (IllegalArgumentException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
        public void deleteUser(@PathVariable Long id) {
         userRepository.delete(id);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User newUser = userRepository.findOne(id);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setEmail(user.getEmail());
        newUser.setEnabled(user.getEnabled());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        userRepository.save(newUser);

        return newUser;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object[] test() {

        String url = "http://document-service/documents";
        Object[] response = restTemplate.getForObject(url, Object[].class);
        return response;
    }

}
