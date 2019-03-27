package nwt.tim14.microservices.post.Repositories;

import nwt.tim14.microservices.post.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
