package nwt.tim14.microservices.document.Controllers;

import nwt.tim14.microservices.document.DTOs.DocumentDTO;
import nwt.tim14.microservices.document.Entities.Document;
import nwt.tim14.microservices.document.Entities.DocumentContent;
import nwt.tim14.microservices.document.Repositories.DocumentContentRepository;
import nwt.tim14.microservices.document.Repositories.DocumentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/documents")
public class ApiController {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentContentRepository documentContentRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DocumentDTO getDocumentById(@PathVariable UUID id, final HttpServletResponse response) {

        Document document = documentRepository.findOne(id);

        if(document == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        return DocumentDTO.getFromDocument(document);
    }

    @RequestMapping(value = "/{id}/content", method = RequestMethod.GET)
    @ResponseBody
    public void getDocumentContent(@PathVariable UUID id, final HttpServletResponse response) {

        try {
            Document document = documentRepository.findOne(id);

            if (document == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            response.addHeader("Content-Disposition",
                    "inline; filename=" + document.getName() + "." + document.getExtension());
            response.setContentType(document.getMimeType());
            StreamUtils.copy(document.getContent().getContent(), response.getOutputStream());
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteDocument(@PathVariable UUID id, final HttpServletResponse response) {

        try {
            Document document = documentRepository.findOne(id);

            if (document == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            documentContentRepository.delete(document.getContent().getId());
            documentRepository.delete(document.getId());

        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<DocumentDTO> getAllDocuments(final HttpServletResponse response) {
        Iterable<Document> documents = documentRepository.findAll();

        if(documents == null)
            documents = new ArrayList<>();

        return StreamSupport.stream(documents.spliterator(), true)
                .map(d -> DocumentDTO.getFromDocument(d))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public DocumentDTO createDocument(@RequestParam("file") MultipartFile document, final HttpServletResponse response) {
        try {
            DocumentContent dc = DocumentContent.builder()
                    .content(document.getBytes())
                    .build();

            String originalName = document.getOriginalFilename();
            var extIndex = originalName.lastIndexOf('.');

            documentContentRepository.save(dc);

            Document d = Document.builder()
                    .content(dc)
                    .name(extIndex != -1? originalName.substring(0, extIndex) : originalName)
                    .extension(extIndex != -1? originalName.substring(extIndex): null)
                    .mimeType(document.getContentType())
                    .build();
            documentRepository.save(d);

            return DocumentDTO.getFromDocument(d);
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @RabbitListener(queues = "documentQueue")
    public void receive(String message) {
        System.out.println(message);
    }
}

