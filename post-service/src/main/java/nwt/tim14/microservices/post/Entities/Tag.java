package nwt.tim14.microservices.post.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private String name;

    public Tag(String _name) {
        this.name = _name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
