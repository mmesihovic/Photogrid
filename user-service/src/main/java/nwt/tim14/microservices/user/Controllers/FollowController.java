package nwt.tim14.microservices.user.Controllers;

import nwt.tim14.microservices.user.Entities.Follow;
import nwt.tim14.microservices.user.Repositories.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FollowController  {

    @Autowired
    private FollowRepository followRepository;

    @RequestMapping(value = "/follows", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    @RequestMapping(value = "/follows", method = RequestMethod.POST)
    public void insertFollow(@RequestBody Follow follow) {
        followRepository.save(follow);
    }

    @RequestMapping(value = "follows/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Follow getFollowById(@PathVariable Long id) {
        return followRepository.findOne(id);
    }

    @RequestMapping(value = "follows/{id}", method = RequestMethod.DELETE)
    public void deleteFollow(@PathVariable Long id) {
        followRepository.delete(id);
    }

    @RequestMapping(value = "follows/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Follow updateRole(@PathVariable Long id, @RequestBody Follow follow) {
        Follow newFollow = followRepository.findOne(id);
        newFollow.setFollowedID(follow.getFollowedID());
        newFollow.setFollowerID(follow.getFollowerID());
        newFollow.date = follow.date;
        followRepository.save(newFollow);
        return newFollow;
    }

}
