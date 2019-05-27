package nwt.tim14.microservices.document.Entities;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "document_contents")
public class DocumentContent {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(nullable = false)
    private byte[] content;
}
