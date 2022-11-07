package com.digitopia.backendproject.entity;

import com.digitopia.backendproject.entity.enums.InvitationStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="invitations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Invitation  implements Serializable {

    //@Id
    //@Column(name = "userID")

    @Id
    @SequenceGenerator(name = "seq_invitation", allocationSize = 1)
    @GeneratedValue(generator = "seq_invitation", strategy = GenerationType.SEQUENCE)
   // @Column(name = "id", nullable = false, unique = true)
    private long id;

    @JoinColumn(name = "invitation_user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User userID;

    @Column(name = "invitation_message")
    private String invitationMessage;

    @Column(name = "invitation_status")
    @Enumerated(EnumType.STRING)
    private InvitationStatus invitationStatus;


    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;

}
