package nwt.tim14.microservices.document.Repositories;

import nwt.tim14.microservices.document.Entities.DocumentContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentContentRepository extends CrudRepository<DocumentContent, Long> {

}
