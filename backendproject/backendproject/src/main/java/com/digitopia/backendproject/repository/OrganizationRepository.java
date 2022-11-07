package com.digitopia.backendproject.repository;

import com.digitopia.backendproject.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
