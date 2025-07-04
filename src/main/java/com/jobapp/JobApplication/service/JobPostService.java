package com.jobapp.JobApplication.service;

import com.jobapp.JobApplication.dto.JobPostDto;
import com.jobapp.JobApplication.entity.JobPost;
import com.jobapp.JobApplication.mapper.JobPostMapper;
import com.jobapp.JobApplication.repo.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private JobPostMapper jobPostMapper;

    public List<JobPostDto> getAllJobs() {

        List<JobPost> jobPosts = jobPostRepo.findAll();
        return jobPosts.stream()
                .map(jobPostMapper :: toDto)
                .collect(Collectors.toList());
    }

    public JobPostDto getJob(int id) {
        Optional<JobPost> jobPost = jobPostRepo.findById(id);

        if(jobPost.isEmpty()){
            throw new NoSuchElementException("JobPost with id "+ id + " not exist");
        }
        return jobPostMapper.toDto(jobPost.get());
    }

    public String addJobs(List<JobPostDto> jobPostDtos) {

        List<JobPost> jobPosts = jobPostDtos.stream()
                .map(jobPostMapper :: toEntity)
                .collect(Collectors.toList());
        List<JobPost> save = jobPostRepo.saveAll(jobPosts);

        return "success";
    }

    public String add(JobPostDto jobPostDto) {

        jobPostRepo.save(jobPostMapper.toEntity(jobPostDto));
        return "Success";
    }

    public String update(int id, JobPostDto jobPostDto) {

        Optional<JobPost> jobPost = jobPostRepo.findById(id);

        if (jobPost.isPresent()){
            JobPost jobpostupdate = jobPost.get();

            jobpostupdate.setPostDesc(jobPostDto.getPostDesc());
            jobpostupdate.setPostProfile(jobPostDto.getPostProfile());
            jobpostupdate.setPostTechStack(jobPostDto.getPostTechStack());
            jobpostupdate.setReqExperience(jobPostDto.getReqExperience());

            jobPostRepo.save(jobpostupdate);

            return "Successfully updated";
        }
        else
            return "JobPost id " +id + "not exist";
    }

    public String deleteJobPost(int id) {
        Optional<JobPost> jobPost = jobPostRepo.findById(id);

        if (jobPost.isPresent()){
            jobPostRepo.delete(jobPost.get());
            return "Deleted";
        }
        else
            return "JobPost id " + id + " not exist";
    }
}
