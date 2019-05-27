package nwt.tim14.microservices.user.Controllers;

import nwt.tim14.microservices.user.Entities.Role;
import nwt.tim14.microservices.user.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoleController  {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public void insertRole(@RequestBody Role role) {
        roleRepository.save(role);
    }

    @RequestMapping(value = "roles/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role getRoleById(@PathVariable Long id) {
        return roleRepository.findOne(id);
    }

    @RequestMapping(value = "roles/{id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable Long id) {
        roleRepository.delete(id);
    }

    @RequestMapping(value = "roles/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        Role newRole = roleRepository.findOne(id);
        newRole.setName(role.getName());
        roleRepository.save(newRole);
        return newRole;
    }

}
