package nwt.tim14.microservices.user.Controllers;

import nwt.tim14.microservices.user.Entities.User;
import nwt.tim14.microservices.user.Repositories.RoleRepository;
import nwt.tim14.microservices.user.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

@RestController
public class UserController  {
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8090));
        clientHttpRequestFactory.setProxy(proxy);

        return new RestTemplate(clientHttpRequestFactory);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

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
