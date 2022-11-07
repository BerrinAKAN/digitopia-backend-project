package com.digitopia.backendproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="organizations" , indexes = {
        @Index(name = "index_normalization_name", columnList = "normalized_name"),
        @Index(name = "index_founded_date", columnList = "founded_date"),
        @Index(name = "index_company_size", columnList = "company_size"),
        @Index(name = "index_registry_number", columnList = "registry_number")
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = "contact_email", name = "constraint_unique_contact_email"),
        @UniqueConstraint(columnNames = "registry_number", name = "constraint_unique_registry_number")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Organization implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_organization_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_organization_user", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "normalized_name")
    private String normalizedName;

    @Column(name = "registry_number")
    private String registryNumber;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "founded_date")
    private Date foundedDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "company_size")
    private long companySize;

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
    @JoinColumn(name = "organization_user_id")
    private List<User> users;*/

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "organizations"
    )
    private List<User> users;


}
