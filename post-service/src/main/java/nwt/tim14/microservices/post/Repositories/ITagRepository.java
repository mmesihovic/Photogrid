package nwt.tim14.microservices.post.Repositories;

import nwt.tim14.microservices.post.Entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITagRepository extends CrudRepository<Tag, Long> {

}
