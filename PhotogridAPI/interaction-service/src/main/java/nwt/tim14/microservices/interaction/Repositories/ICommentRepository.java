package nwt.tim14.microservices.interaction.Repositories;

import nwt.tim14.microservices.interaction.Entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends CrudRepository<Comment, Long> {
}
