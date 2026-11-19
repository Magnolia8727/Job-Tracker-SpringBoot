package org.example.jobtracker.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jobtracker.enums.ApplicationStatus;
import org.example.jobtracker.models.Job;
import org.example.jobtracker.repositories.JobRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobService {

    private final JobRepository jobRepository;

    public Job save(Job job) {
        log.info("Job with id {} has been saved", job.getId());
        return jobRepository.save(job);
    }
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    public Job findById(Integer id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job with id " + id + " not found"));
        return job;
    }
    public List<Job> findByStatus(ApplicationStatus status) {
        return jobRepository.findByStatus(status);
    }
    public List<Job> findByCompany(String company)
    {
        return jobRepository.findByCompany(company);
    }
    public List<Job> findByRole(String role)
    {
        return jobRepository.findByRole(role);
    }
    public Job updateById(Integer id, Job job)
    {
        Job jobs = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job with id " + id + " not found"));
        if(job.getCompany() != null)
        {
            jobs.setCompany(job.getCompany());
        }
        if(job.getRole() != null)
        {
            jobs.setRole(job.getRole());
        }
        if(job.getStatus() != null)
        {
            jobs.setStatus(job.getStatus());
        }
        return jobRepository.save(jobs);
    }

    public void deleteById(Integer id) {

        if(!jobRepository.existsById(id)){
            throw new RuntimeException("Job with id " + id + " not found");
        }
        jobRepository.deleteById(id);
        log.info("Job with id {} has been deleted", id);
    }
}
