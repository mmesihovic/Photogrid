package nwt.tim14.microservices.interaction.Controllers;

import nwt.tim14.microservices.interaction.Entities.Reaction;
import nwt.tim14.microservices.interaction.Repositories.ICommentRepository;
import nwt.tim14.microservices.interaction.Repositories.IPostRepository;
import nwt.tim14.microservices.interaction.Repositories.IReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private ICommentRepository commentRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IReactionRepository reactionRepository;

    @RequestMapping(value = "/interactions/start")
    public void Start() {

        Reaction likeReaction = Reaction.builder()
                .type("Like")
                .build();

        Reaction sadReaction = Reaction.builder()
                .type("Sad")
                .build();

        Reaction wowReaction = Reaction.builder()
                .type("Wow")
                .build();

        Reaction loveReaction = Reaction.builder()
                .type("Love")
                .build();

        Reaction angryReaction = Reaction.builder()
                .type("Angry")
                .build();

        reactionRepository.save(likeReaction);
        reactionRepository.save(sadReaction);
        reactionRepository.save(wowReaction);
        reactionRepository.save(loveReaction);
        reactionRepository.save(angryReaction);

        List<Reaction> postReactions = new ArrayList<Reaction>();
        postReactions.add(likeReaction);
        postReactions.add(likeReaction);
        postReactions.add(wowReaction);



    }



}
