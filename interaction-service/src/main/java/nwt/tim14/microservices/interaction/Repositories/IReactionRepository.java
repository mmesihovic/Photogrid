package nwt.tim14.microservices.interaction.Repositories;

import nwt.tim14.microservices.interaction.Entities.Reaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactionRepository extends CrudRepository<Reaction, Long> {

}
