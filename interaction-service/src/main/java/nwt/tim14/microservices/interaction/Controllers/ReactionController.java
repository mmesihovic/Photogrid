package nwt.tim14.microservices.interaction.Controllers;

import nwt.tim14.microservices.interaction.Entities.Reaction;
import nwt.tim14.microservices.interaction.Repositories.IReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReactionController {

    @Autowired
    private IReactionRepository reactionRepository;

    @RequestMapping(value = "/interactions/reactions", method = RequestMethod.GET)
    public Iterable<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

    @RequestMapping(value = "/interactions/reactions", method = RequestMethod.POST)
    public void addReation(@RequestBody Reaction reaction) {
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
