package nwt.tim14.microservices.document.Entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String extension;
    //@OneToOne
    //@JoinColumn(name="contentID")
    @Column
    private Long contentID;
    @Column
    private Date createdAt;
    @Column
    private String mimeType;


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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getContentID() {
        return contentID;
    }

    public void setContentID(Long contentID) {
        this.contentID = contentID;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }


    public Document(String _name, String _extension, Long _contentID, Date _createdAt, String _mimeType) {
        this.name = _name;
        this.extension = _extension;
        this.contentID = _contentID;
        this.createdAt = _createdAt;
        this.mimeType = _mimeType;

    }
}
