package nwt.tim14.microservices.post.Entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import org.aspectj.weaver.Iterators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Column(name="createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Size(min=0, max=350)
    private String decription;
    private Long reactions;
    private Long comments;

    @Column
    @NotNull
    private Long userID;

    @ManyToMany
    @JoinTable(
            name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Tag> tags;
}
