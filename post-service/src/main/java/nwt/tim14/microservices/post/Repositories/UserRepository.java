package nwt.tim14.microservices.post.Repositories;

import nwt.tim14.microservices.post.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
