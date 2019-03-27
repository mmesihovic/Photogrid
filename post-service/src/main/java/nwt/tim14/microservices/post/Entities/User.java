package nwt.tim14.microservices.post.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private String username;

    public User(String _username) {
        this.username = _username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUserame(String username) {
        this.username = username;
    }
}
