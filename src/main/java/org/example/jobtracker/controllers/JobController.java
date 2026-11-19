package org.example.jobtracker.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jobtracker.enums.ApplicationStatus;
import org.example.jobtracker.models.Job;
import org.example.jobtracker.services.JobService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {
    private JobService jobService;
    @PostMapping
    public Job save(@Valid @RequestBody Job job)
    {
       return jobService.save(job);
    }
    @GetMapping
    public List<Job> findAll()
    {
        return jobService.findAll();
    }
    @GetMapping("/{id}")
    public Job findById(@PathVariable Integer id)
    {
        return jobService.findById(id);
    }
    @GetMapping("/company/{company}")
    public List<Job> findByCompany(@PathVariable String company)
    {
        return jobService.findByCompany(company);
    }
    @GetMapping("/status/{status}")
    public List<Job> findByStatus(@PathVariable ApplicationStatus status)
    {
        return jobService.findByStatus(status);
    }
    @PutMapping("/{id}")
    public Job update(@PathVariable Integer id, @RequestBody Job job)
    {
        return jobService.updateById(id, job);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id)
    {
        jobService.deleteById(id);
    }
}
