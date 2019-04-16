package nwt.tim14.microservices.interaction.Entities;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private Long reactions;
    @Column
    private Long comments;

    @Column
    @NotNull
    private Long userID;

    @ManyToMany
    @JoinTable(
            name = "posts_reactions",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "reaction_id", referencedColumnName = "id")
    )
    private List<Reaction> reactionsList;

}