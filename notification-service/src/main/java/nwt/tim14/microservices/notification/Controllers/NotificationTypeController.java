package nwt.tim14.microservices.notification.Controllers;

import nwt.tim14.microservices.notification.Entities.NotificationType;
import nwt.tim14.microservices.notification.Repositories.INotificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationTypeController {

    @Autowired
    private INotificationTypeRepository notificationTypeRepository;

    @RequestMapping(value = "/notifications/types", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<NotificationType> getAllNotificationTypes() {
        return notificationTypeRepository.findAll();
    }

    @RequestMapping(value = "/notifications/types", method = RequestMethod.POST)
    public void addNotification(@RequestBody NotificationType notificationType) {
        notificationTypeRepository.save(notificationType);
    }

    @RequestMapping(value = "/notifications/types/{id}", method = RequestMethod.GET)
    @ResponseBody
    public NotificationType getNotificationTypesById(@PathVariable Long id) {
        return notificationTypeRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/notifications/types/{id}", method = RequestMethod.DELETE)
    public void deleteNotificationType(@PathVariable Long id) {
        notificationTypeRepository.deleteById(id);
    }

    @RequestMapping(value = "/notifications/types/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public NotificationType updateNotificationType(@PathVariable Long id, @RequestBody NotificationType notificationType) {

        NotificationType newNotificationType = notificationTypeRepository.findById(id).orElse(null);

        newNotificationType.setType(notificationType.getType());

        notificationTypeRepository.save(newNotificationType);

        return newNotificationType;

    }
}
