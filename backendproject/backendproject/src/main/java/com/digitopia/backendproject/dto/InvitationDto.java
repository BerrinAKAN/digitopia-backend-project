package com.digitopia.backendproject.dto;

import com.digitopia.backendproject.entity.User;
import com.digitopia.backendproject.entity.enums.InvitationStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvitationDto {

    private long id;

    private User userID;

    private String invitationMessage;

    private InvitationStatus invitationStatus;

    private LocalDateTime createdOn;

    private String createdBy;

    private LocalDateTime updatedOn;

    private String updatedBy;

}
