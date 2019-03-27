package nwt.tim14.microservices.post.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private Date postDate;
    @Column
    private String decription;
    @Column
    private Long reactions;
    @Column
    private Long comments;

    public Post( Date _date, String _description, Long _reactions, Long _comments) {
        this.postDate = _date;
        this.decription = _description;
        this.reactions = _reactions;
        this.comments = _comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Long getReactions() {
        return reactions;
    }

    public void setReactions(Long reactions) {
        this.reactions = reactions;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }
}
