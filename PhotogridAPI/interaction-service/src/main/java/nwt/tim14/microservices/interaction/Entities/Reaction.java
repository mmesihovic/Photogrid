package nwt.tim14.microservices.interaction.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Reactions")
public class Reaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private Long userID;

    @ManyToOne
    @JoinColumn(name="typeID", nullable=false)
    private ReactionType type;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "comments_reactions",
            joinColumns = @JoinColumn(name = "reaction_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id")
    )
    private List<Comment> comments;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "posts_reactions",
            joinColumns = @JoinColumn(name = "reaction_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id")
    )
    private List<Post> posts;
}
