package nwt.tim14.microservices.post.Repositories;

import nwt.tim14.microservices.post.Entities.TagPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagPostRepository extends CrudRepository<TagPost, Long> {
}
