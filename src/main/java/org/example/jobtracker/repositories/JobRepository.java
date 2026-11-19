package org.example.jobtracker.repositories;

import org.example.jobtracker.enums.ApplicationStatus;
import org.example.jobtracker.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {

    List<Job> findByCompany(String company);
    List<Job> findByRole(String role);
    List<Job> findByStatus(ApplicationStatus status);

    boolean existsByCompany(String company);
    boolean existsByRole(String role);


}
