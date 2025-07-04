package com.jobapp.JobApplication.repo;

import com.jobapp.JobApplication.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepo extends JpaRepository<JobPost , Integer > {
}
