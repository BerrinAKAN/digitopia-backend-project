package com.digitopia.backendproject.entity;

import com.digitopia.backendproject.entity.enums.UserStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="users", indexes = {
        @Index(name = "index_user_id", columnList = "id"),
        @Index(name = "index_email", columnList = "email"),
        @Index(name = "index_normalized_name", columnList = "normalized_name")
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "constraint_unique_email")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_organization", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_organization", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name="user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(name="full_name")
    private String fullName;

    @Column(name="email")
    private String Email;

    @Column(name="normalized_name")
    private String normalizedName;


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

    /*@OneToMany
    @JoinColumn(name = "user_organization_id")
    List<Organization> organizations;*/

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Organization.class
    )
    List<Organization> organizations;

    @OneToOne
    @JoinColumn(name = "invitation_user_id")
    private Invitation invitationID;



}
