package nwt.tim14.microservices.user.Controllers;

import nwt.tim14.microservices.user.Entities.User;
import nwt.tim14.microservices.user.Repositories.RoleRepository;
import nwt.tim14.microservices.user.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController  {

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

}
