package nwt.tim14.microservices.user.Repositories;

import nwt.tim14.microservices.user.Entities.Follow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Long> {

}
