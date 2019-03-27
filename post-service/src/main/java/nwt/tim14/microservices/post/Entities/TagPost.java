package nwt.tim14.microservices.post.Entities;

import javax.persistence.*;

@Entity
public class TagPost {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private Long tagID;
    @Column
    private Long postID;

    public TagPost(Long _tagID, Long _postID) {
        this.tagID = _tagID;
        this.postID = _postID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTagID() {
        return tagID;
    }

    public void setTagID(Long tagID) {
        this.tagID = tagID;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }
}
