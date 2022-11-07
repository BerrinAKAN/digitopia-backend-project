package com.digitopia.backendproject.dto;

import com.digitopia.backendproject.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrganizationDto {

    private long id;

    private String organizationName;

    private String normalizedName;

    private String registryNumber;

    private String contactEmail;

    private Date foundedDate;

    private String phone;

    private long companySize;

    private LocalDateTime createdOn;

    private String createdBy;

    private LocalDateTime updatedOn;

    private String updatedBy;

    private List<User> users;
}
