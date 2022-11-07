package com.digitopia.backendproject.service.impl;

import com.digitopia.backendproject.dto.OrganizationDto;
import com.digitopia.backendproject.dto.UserDto;
import com.digitopia.backendproject.entity.Organization;
import com.digitopia.backendproject.entity.User;
import com.digitopia.backendproject.repository.OrganizationRepository;
import com.digitopia.backendproject.repository.UserRepository;
import com.digitopia.backendproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private  final OrganizationDto organizationDto;

    @Override
    @Transactional
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User updateUserById(Long id, User user) {

        User updatedUser = userRepository.findById(id).get();

        updatedUser.setUserStatus(user.getUserStatus());
        updatedUser.setFullName(user.getFullName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setNormalizedName(user.getNormalizedName());
        updatedUser.setCreatedOn(LocalDateTime.now());
        updatedUser.setCreatedBy(user.getCreatedBy());
        updatedUser.setUpdatedOn(LocalDateTime.now());
        updatedUser.setUpdatedBy(user.getUpdatedBy());
        return userRepository.save(updatedUser);

    }

    @Override
    public User getByUserId(Long id) {
        return userRepository.findById(id).get();

    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }


    @Override
    public List<Organization> getAllOrganizationsForUser(Long userId) {
        User user = userRepository.findById(userId).get();
        return user.getOrganizations().stream().collect(Collectors.toList());
    }

    @Override
    public User searchByEmail(String email) {
        return null;
    }

    @Override
    public List<User> searchByNormalizedName(UserDto normalizedName) {
        return null;
    }
}
