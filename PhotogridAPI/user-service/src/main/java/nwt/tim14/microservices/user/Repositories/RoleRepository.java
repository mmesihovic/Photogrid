package nwt.tim14.microservices.user.Repositories;

import nwt.tim14.microservices.user.Entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
