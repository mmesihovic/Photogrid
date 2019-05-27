package nwt.tim14.microservices.notification.Controllers;

import nwt.tim14.microservices.notification.Entities.Notification;
import nwt.tim14.microservices.notification.Entities.NotificationType;
import nwt.tim14.microservices.notification.Repositories.INotificationRepository;
import nwt.tim14.microservices.notification.Repositories.INotificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private INotificationRepository notificationRepository;
    @Autowired
    private INotificationTypeRepository notificationTypeRepository;

    @RequestMapping("/notifications/start")
    public void Start() {

        NotificationType reminderType = NotificationType.builder()
                .type("Reminder")
                .build();
        NotificationType reactionType = NotificationType.builder()
                .type("Reaction")
                .build();
        NotificationType commentType = NotificationType.builder()
                .type("Comment")
                .build();
        NotificationType newsType = NotificationType.builder()
                .type("News")
                .build();

        notificationTypeRepository.save(reminderType);
        notificationTypeRepository.save(reactionType);
        notificationTypeRepository.save(commentType);
        notificationTypeRepository.save(newsType);

        Notification firstNotification = Notification.builder()
                .userID(5L)
                .type(commentType)
                .content("User X has commented on your post.")
                .checked(false)
                .build();

        Notification secondNotification = Notification.builder()
                .userID(10L)
                .type(reactionType)
                .content("Uset Y has reacted to your post.")
                .checked(true)
                .build();

        notificationRepository.save(firstNotification);
        notificationRepository.save(secondNotification);
    }
}
