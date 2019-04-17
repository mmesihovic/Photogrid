package nwt.tim14.microservices.interaction.Controllers;

import com.netflix.discovery.converters.Auto;
import nwt.tim14.microservices.interaction.Entities.Comment;
import nwt.tim14.microservices.interaction.Entities.Post;
import nwt.tim14.microservices.interaction.Entities.Reaction;
import nwt.tim14.microservices.interaction.Entities.ReactionType;
import nwt.tim14.microservices.interaction.Repositories.ICommentRepository;
import nwt.tim14.microservices.interaction.Repositories.IPostRepository;
import nwt.tim14.microservices.interaction.Repositories.IReactionRepository;
import nwt.tim14.microservices.interaction.Repositories.IReactionTypeRepository;
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
    @Autowired
    private IReactionTypeRepository reactionTypeRepository;

    @RequestMapping(value = "/interactions/start")
    public void Start() {

        ReactionType likeReactionType = ReactionType.builder()
                .type("Like")
                .build();

        ReactionType sadReactionType = ReactionType.builder()
                .type("Sad")
                .build();

        ReactionType wowReactionType = ReactionType.builder()
                .type("Wow")
                .build();

        ReactionType loveReactionType = ReactionType.builder()
                .type("Love")
                .build();

        ReactionType angryReactionType = ReactionType.builder()
                .type("Angry")
                .build();

        reactionTypeRepository.save(likeReactionType);
        reactionTypeRepository.save(sadReactionType);
        reactionTypeRepository.save(wowReactionType);
        reactionTypeRepository.save(loveReactionType);
        reactionTypeRepository.save(angryReactionType);

        Reaction testReaction = Reaction.builder()
                .type(likeReactionType)
                .userID(12L)
                .build();

        Reaction testReaction2 = Reaction.builder()
                .type(loveReactionType)
                .userID(14L)
                .build();

        reactionRepository.save(testReaction);
        reactionRepository.save(testReaction2);

        List<Reaction> postReactions = new ArrayList<Reaction>();
        postReactions.add(testReaction);
        postReactions.add(testReaction2);

        Post testPost = Post.builder()
                .userID(14L)
                .reactions(2L)
                .comments(1L)
                .reactionsList(postReactions)
                .build();

        postReactions.add(testReaction);
        postReactions.add(testReaction);
        Post testPost2 = Post.builder()
                .userID(14L)
                .reactions(2L)
                .comments(1L)
                .reactionsList(postReactions)
                .build();

        postRepository.save(testPost);
        postRepository.save(testPost2);

        Comment testComment = Comment.builder()
                .post(testPost)
                .content("Testni Komentar")
                .reactions(0L)
                .userID(12L)
                .reactionsList(new ArrayList<Reaction>())
                .build();

        Comment testComment2 = Comment.builder()
                .post(testPost2)
                .content("Testni Komentar")
                .reactions(0L)
                .userID(12L)
                .reactionsList(new ArrayList<Reaction>())
                .build();

        commentRepository.save(testComment);
        commentRepository.save(testComment2);

    }



}
