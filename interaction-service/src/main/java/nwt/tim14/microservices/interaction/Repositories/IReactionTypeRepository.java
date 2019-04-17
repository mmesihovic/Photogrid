package nwt.tim14.microservices.interaction.Repositories;

import nwt.tim14.microservices.interaction.Entities.ReactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactionTypeRepository extends CrudRepository<ReactionType, Long> {
}
