package nwt.tim14.microservices.notification.Repositories;

import nwt.tim14.microservices.notification.Entities.NotificationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationTypeRepository extends CrudRepository<NotificationType, Long> {
}
