package nwt.tim14.microservices.post.Controllers;

import nwt.tim14.microservices.post.Entities.Post;
import nwt.tim14.microservices.post.Repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private IPostRepository postRepository;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        System.out.print(post);
        postRepository.save(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findOne(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postRepository.delete(id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {

        Post newPost = postRepository.findOne(id);

        newPost.setDecription(post.getDecription());
        newPost.setComments(post.getComments());
        newPost.setReactions(post.getReactions());
        newPost.setTags(post.getTags());
        newPost.setUserID(post.getUserID());

        postRepository.save(newPost);

        return newPost;
    }
}
