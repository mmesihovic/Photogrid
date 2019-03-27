package nwt.tim14.microservices.post.DBHelper;

import nwt.tim14.microservices.post.Entities.Post;
import nwt.tim14.microservices.post.Entities.Tag;
import nwt.tim14.microservices.post.Entities.TagPost;
import nwt.tim14.microservices.post.Entities.User;
import nwt.tim14.microservices.post.Repositories.PostRepository;
import nwt.tim14.microservices.post.Repositories.TagPostRepository;
import nwt.tim14.microservices.post.Repositories.TagRepository;
import nwt.tim14.microservices.post.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PostDBInitializer implements ApplicationRunner {
    private PostRepository postRepository;
    private TagRepository tagRepository;
    private TagPostRepository tagPostRepository;
    private UserRepository userRepository;

    @Autowired
    public PostDBInitializer(PostRepository _postRepository, TagRepository _tagRepository, TagPostRepository _tagPostRepository, UserRepository _userRepository) {
        this.postRepository = _postRepository;
        this.tagPostRepository = _tagPostRepository;
        this.tagRepository = _tagRepository;
        this.userRepository = _userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long postRows = postRepository.count();
        long tagRows = tagRepository.count();
        long tagPostRows = tagPostRepository.count();
        long userRows = userRepository.count();

        if( postRows == 0 ) {
            postRepository.save(new Post(new Date(), "Prvi Post", 10L, 0L));
            postRepository.save(new Post(new Date(), "Drugi Post", 15L, 10L));
        }
        if( tagRows == 0 ) {
            tagRepository.save(new Tag("testni tag 1"));
            tagRepository.save(new Tag("testni tag 2"));
        }
        if( tagPostRows == 0) {
            tagPostRepository.save(new TagPost(1L, 1L));
            tagPostRepository.save(new TagPost(1L,2L));
        }
        if( userRows == 0) {
            userRepository.save(new User("mmesihovic"));
            userRepository.save(new User("ihalilovic"));
            userRepository.save(new User("rsabanovic"));
        }

    }
}
