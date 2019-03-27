package nwt.tim14.microservices.document.Entities;


import javax.persistence.*;

@Entity
public class DocumentContent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long contentID;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] content;


    public Long getContentID() {
        return contentID;
    }

    public void setContentID(Long contentID) {
        this.contentID = contentID;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public DocumentContent(byte[] _content) {
        this.content = _content;
    }
}
