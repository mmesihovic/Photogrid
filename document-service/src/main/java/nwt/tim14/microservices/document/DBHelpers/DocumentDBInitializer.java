package nwt.tim14.microservices.document.DBHelpers;

import nwt.tim14.microservices.document.Entities.Document;
import nwt.tim14.microservices.document.Entities.DocumentContent;
import nwt.tim14.microservices.document.Repositories.DocumentContentRepository;
import nwt.tim14.microservices.document.Repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DocumentDBInitializer implements ApplicationRunner {

    private DocumentRepository documentRepository;
    private DocumentContentRepository documentContentRepository;

    @Autowired
    public DocumentDBInitializer(DocumentRepository _documentRepository, DocumentContentRepository _documentContentRepository) {
        this.documentRepository = _documentRepository;
        this.documentContentRepository = _documentContentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long rows = documentRepository.count();

        if(rows == 0) {
            documentRepository.save(new Document("Test", "jpg",null, new Date(), "neki tip" ));
            documentContentRepository.save(new DocumentContent(null));
        }
    }

}
