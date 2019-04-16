package nwt.tim14.microservices.interaction.Entities;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column
    @NotNull
    private Long userID;

    @Column
    @NotNull
    @Length(min=0, max=255)
    private String content;

    @Column
    private Long reactions;

    @ManyToOne
    @JoinColumn(name = "postID", nullable = false)
    private Post post;

    @ManyToMany
    @JoinTable(
            name = "comments_reactions",
            joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "reaction_id", referencedColumnName = "id")
    )
    private List<Reaction> reactionsList;

}
