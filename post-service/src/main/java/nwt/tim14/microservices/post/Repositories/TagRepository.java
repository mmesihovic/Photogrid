package nwt.tim14.microservices.post.Repositories;

import nwt.tim14.microservices.post.Entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
