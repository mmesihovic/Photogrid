package nwt.tim14.microservices.user.Entities;

import javax.persistence.*;

@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private Long followerID;
    @Column
    private Long followedID;

    public Follow(Long followerID, Long followedID) {
        this.followerID = followerID;
        this.followedID = followedID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowerID() {
        return followerID;
    }

    public void setFollowerID(Long followerID) {
        this.followerID = followerID;
    }

    public Long getFollowedID() {
        return followedID;
    }

    public void setFollowedID(Long followedID) {
        this.followedID = followedID;
    }
}
