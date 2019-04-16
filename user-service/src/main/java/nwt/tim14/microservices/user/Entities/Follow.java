package nwt.tim14.microservices.user.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Follow {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="follower_id")
    private User followerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="followed_id")
    private User followedID;

    @Column
    public Date date;

    public Follow() {}

    public Follow( User follower, User followed, Date date) {
        this.followerID = follower;
        this.followedID = followed;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFollowerID() {
        return followerID;
    }

    public void setFollowerID(User follower) {
        this.followerID = follower;
    }

    public User getFollowedID() {
        return followedID;
    }

    public void setFollowedID(User followed) {
        this.followedID = followed;
    }
}
