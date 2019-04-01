package nwt.tim14.microservices.document.Controllers;

import nwt.tim14.microservices.document.Entities.Document;
import nwt.tim14.microservices.document.Entities.DocumentContent;
import nwt.tim14.microservices.document.Repositories.DocumentContentRepository;
import nwt.tim14.microservices.document.Repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ApiController {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentContentRepository documentContentRepository;

    @RequestMapping("/start")
    public void Start() {
        String content = "test sadrzaj";
        DocumentContent docCon = DocumentContent.builder()
                .id(UUID.randomUUID())
                .content(content.getBytes())
                .build();
        documentContentRepository.save(docCon);
        Document doc = Document.builder()
                .id(UUID.randomUUID())
                .name("test")
                .extension("txt")
                .mimeType("plain/text")
                //.createdAt(new Date())
                .content(docCon)
                .build();

        documentRepository.save(doc);
    }
}

