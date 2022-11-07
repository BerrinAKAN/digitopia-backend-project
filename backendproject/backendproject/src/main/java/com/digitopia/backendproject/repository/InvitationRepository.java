package com.digitopia.backendproject.repository;

import com.digitopia.backendproject.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation,Long> {
}
