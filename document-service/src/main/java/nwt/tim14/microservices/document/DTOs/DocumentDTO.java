package nwt.tim14.microservices.document.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nwt.tim14.microservices.document.Entities.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DocumentDTO {

    private String url;

    private String name;

    private String extension;

    private String mimeType;

    private Date createdAt;


    public static DocumentDTO getFromDocument(Document document) {
        return new DocumentDTO("/documents/" + document.getId() + "/content",
                document.getName(),
                document.getExtension(),
                document.getMimeType(),
                document.getCreatedAt());
    }

    public DocumentDTO(String url, String name, String extension, String mimeType, Date createdAt) {
        this.url = url;
        this.name = name;
        this.extension = extension;
        this.mimeType = mimeType;
        this.createdAt = createdAt;
    }
}
