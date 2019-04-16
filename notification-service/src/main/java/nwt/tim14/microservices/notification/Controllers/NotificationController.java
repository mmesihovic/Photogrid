package nwt.tim14.microservices.notification.Controllers;

import nwt.tim14.microservices.notification.Entities.Notification;
import nwt.tim14.microservices.notification.Repositories.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {

    @Autowired
    private INotificationRepository notificationRepository;

    @RequestMapping(value = "/notifications", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @RequestMapping(value = "/notifications", method = RequestMethod.POST)
    public void addNotification(@RequestBody Notification notification) {
        notificationRepository.save(notification);
    }

    @RequestMapping(value = "/notifications/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/notifications/{id}", method = RequestMethod.DELETE)
    public void deleteNotification(@PathVariable Long id) {
        notificationRepository.deleteById(id);
    }

    @RequestMapping(value = "/notifications/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification notification) {

        Notification newNotification = notificationRepository.findById(id).orElse(null);

        newNotification.setType(notification.getType());
        newNotification.setContent(notification.getContent());
        newNotification.setChecked(notification.getChecked());
        newNotification.setUserID(notification.getUserID());

        notificationRepository.save(newNotification);

        return newNotification;

    }

}
