package nwt.tim14.microservices.interaction.Controllers;

import nwt.tim14.microservices.interaction.Entities.Comment;
import nwt.tim14.microservices.interaction.Repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private ICommentRepository commentRepository;

    @RequestMapping(value = "/interactions/comments", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @RequestMapping(value = "/interactions/comments", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
    }

    @RequestMapping(value = "/interactions/comments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Comment getCommentById(@RequestParam Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/interactions/comments/{id}", method = RequestMethod.DELETE)
    public void deleteCommentById(@RequestParam Long id) {
        commentRepository.deleteById(id);
    }

    @RequestMapping(value = "/interactions/comments/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Comment updatePostById(@RequestParam Long id, @RequestBody Comment comment) {

        Comment newComment = commentRepository.findById(id).orElse(null);

        newComment.setPost(comment.getPost());
        newComment.setContent(comment.getContent());
        newComment.setUserID(comment.getUserID());
        newComment.setReactions(comment.getReactions());
        newComment.setReactionsList(comment.getReactionsList());

        commentRepository.save(newComment);

        return newComment;
    }

}
