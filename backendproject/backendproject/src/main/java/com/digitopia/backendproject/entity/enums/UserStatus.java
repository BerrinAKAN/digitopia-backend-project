package com.digitopia.backendproject.entity.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE,
    PENDING,
    DEACTIVATED,
    INVITED,
    PASSIVE,
    DELETED
}
