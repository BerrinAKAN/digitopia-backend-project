package com.digitopia.backendproject.service;

import com.digitopia.backendproject.dto.OrganizationDto;
import com.digitopia.backendproject.dto.UserDto;
import com.digitopia.backendproject.entity.Organization;
import com.digitopia.backendproject.entity.User;


import java.util.List;

public interface UserService {

    User saveUser(User user);

    void  deleteUserById(Long id);

    User updateUserById(Long id, User user);

    User getByUserId(Long id);

    List<User> getAllUsers();

    List<Organization> getAllOrganizationsForUser(Long userId);

    User searchByEmail(String email);

    List<User> searchByNormalizedName(UserDto normalizedName);


}
