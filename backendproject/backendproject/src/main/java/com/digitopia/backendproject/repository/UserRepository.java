package com.digitopia.backendproject.repository;

import com.digitopia.backendproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

  @Query("select u from users u where u.email like concat('%',:query, '%') ")
    List<User> searchEmail(String query);

    @Query("select u from users u where u.normalized_name like concat('%',:query, '%') ")
    List<User> searchNormalizedName(String query);

}
