package nwt.tim14.microservices.interaction.Repositories;

import nwt.tim14.microservices.interaction.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends CrudRepository<Post, Long> {
}
