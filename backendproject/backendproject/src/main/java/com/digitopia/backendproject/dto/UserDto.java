package com.digitopia.backendproject.dto;

import com.digitopia.backendproject.entity.Organization;
import com.digitopia.backendproject.entity.enums.UserStatus;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private long id;

    private UserStatus userStatus;

    private String fullName;

    private String Email;

    private String normalizedName;

    private LocalDateTime createdOn;

    private String createdBy;

    private LocalDateTime updatedOn;

    private String updatedBy;

    List<Organization> organizations;

}
