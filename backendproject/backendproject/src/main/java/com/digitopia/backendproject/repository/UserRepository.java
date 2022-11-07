package com.digitopia.backendproject.repository;

import com.digitopia.backendproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {


}
