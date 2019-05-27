package nwt.tim14.microservices.post.Repositories;

import nwt.tim14.microservices.post.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPostRepository extends CrudRepository<Post, Long> {
}
