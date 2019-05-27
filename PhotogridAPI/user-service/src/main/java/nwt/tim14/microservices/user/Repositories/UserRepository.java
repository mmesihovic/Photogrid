package nwt.tim14.microservices.user.Repositories;

import nwt.tim14.microservices.user.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
