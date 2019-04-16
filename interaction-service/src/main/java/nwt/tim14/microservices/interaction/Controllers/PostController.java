package nwt.tim14.microservices.interaction.Controllers;

import nwt.tim14.microservices.interaction.Entities.Post;
import nwt.tim14.microservices.interaction.Repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private IPostRepository postRepository;

    @RequestMapping(value = "interactions/posts", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(value = "interactions/posts", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postRepository.save(post);
    }

    @RequestMapping(value = "interactions/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "interactions/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @RequestMapping(value = "interactions/posts/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {

        Post newPost = postRepository.findById(id).orElse(null);

        newPost.setUserID(post.getUserID());
        newPost.setComments(post.getComments());
        newPost.setReactions(post.getReactions());
        newPost.setReactionsList(post.getReactionsList());

        postRepository.save(newPost);

        return newPost;
    }
}
