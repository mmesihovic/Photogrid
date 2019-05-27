package nwt.tim14.microservices.interaction.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificationDTO {

    private String type;

    private Long postId;

    private Long userId;


}
