package nwt.tim14.microservices.interaction.Controllers;

import nwt.tim14.microservices.interaction.Entities.ReactionType;
import nwt.tim14.microservices.interaction.Repositories.IReactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReactionTypeController {

    @Autowired
    private IReactionTypeRepository reactionTypeRepository;

    @RequestMapping(value = "interactions/reactions/types", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<ReactionType> getAllReactionTypes() {
        return reactionTypeRepository.findAll();
    }

    @RequestMapping(value = "interactions/reactions/types", method = RequestMethod.POST)
    public void addReaction(@RequestBody ReactionType ReactionType) {
        reactionTypeRepository.save(ReactionType);
    }

    @RequestMapping(value = "interactions/reactions/types/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ReactionType getReactionTypesById(@PathVariable Long id) {
        return reactionTypeRepository.findOne(id);
    }

    @RequestMapping(value = "interactions/reactions/types/{id}", method = RequestMethod.DELETE)
    public void deleteReactionType(@PathVariable Long id) {
        reactionTypeRepository.delete(id);
    }

    @RequestMapping(value = "/interactions/reactions/types/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ReactionType updateReactionType(@PathVariable Long id, @RequestBody ReactionType ReactionType) {

        nwt.tim14.microservices.interaction.Entities.ReactionType newReactionType = reactionTypeRepository.findOne(id);

        newReactionType.setType(ReactionType.getType());

        reactionTypeRepository.save(newReactionType);

        return newReactionType;

    }
}
