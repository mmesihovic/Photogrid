package nwt.tim14.microservices.post.Controllers;


import nwt.tim14.microservices.post.Entities.Post;
import nwt.tim14.microservices.post.Entities.Tag;
import nwt.tim14.microservices.post.Repositories.IPostRepository;
import nwt.tim14.microservices.post.Repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ApiController {

    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private ITagRepository tagRepository;

    @RequestMapping("/posts/start")
    public void Start() {

        Tag tag1 = Tag.builder()
                .name("hesteg")
                .build();

        Tag tag2 = Tag.builder()
                .name("hesteg2")
                .build();

        tagRepository.save(tag1);
        tagRepository.save(tag2);

        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag1);
        tags.add(tag2);

        Post post = Post.builder()
                .decription("Neki description")
                .comments(20L)
                .reactions(20L)
                .userID(3524L)
                .tags(tags)
                .build();

        postRepository.save(post);
    }


}
