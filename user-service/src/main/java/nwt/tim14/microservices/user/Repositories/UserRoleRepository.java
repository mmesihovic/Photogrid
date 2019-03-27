package nwt.tim14.microservices.user.Repositories;

import nwt.tim14.microservices.user.Entities.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
