package nwt.tim14.microservices.notification.Repositories;

import nwt.tim14.microservices.notification.Entities.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends CrudRepository<Notification, Long> {
}
