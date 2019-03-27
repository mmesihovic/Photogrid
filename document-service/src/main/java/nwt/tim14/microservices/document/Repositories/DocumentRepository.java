package nwt.tim14.microservices.document.Repositories;

import nwt.tim14.microservices.document.Entities.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
}
