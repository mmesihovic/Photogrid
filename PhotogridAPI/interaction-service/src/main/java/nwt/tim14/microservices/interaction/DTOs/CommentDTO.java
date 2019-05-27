package nwt.tim14.microservices.interaction.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private Long userId;

    private String content;

    private Long postId;
}
