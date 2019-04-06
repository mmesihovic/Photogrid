package nwt.tim14.microservices.user.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="follower_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name="followed_id")
    private User followed;

    @Column
    public Date date;

    public Follow(User follower, User followed, Date date) {
        this.follower = follower;
        this.followed = followed;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFollowerID() {
        return follower;
    }

    public void setFollowerID(User follower) {
        this.follower = follower;
    }

    public User getFollowedID() {
        return followed;
    }

    public void setFollowedID(User followed) {
        this.followed = followed;
    }
}
