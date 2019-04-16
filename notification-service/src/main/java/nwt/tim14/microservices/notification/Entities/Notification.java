package nwt.tim14.microservices.notification.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="typeID", nullable=false)
    //@JsonIgnore
    private NotificationType type;

    @Column
    @NotNull
    private Long userID;

    @Column
    @NotNull
    @Size(min=0, max=350)
    private String content;

    @Column
    @NotNull
    private Boolean checked;
}


