package com.jobapp.JobApplication.mapper;

import com.jobapp.JobApplication.dto.JobPostDto;
import com.jobapp.JobApplication.entity.JobPost;
import org.springframework.stereotype.Component;

@Component
public class JobPostMapper {

    public  JobPostDto toDto(JobPost entity) {
        return new JobPostDto(
                entity.getPostId(),
                entity.getPostProfile(),
                entity.getPostDesc(),
                entity.getReqExperience(),
                entity.getPostTechStack()
        );
    }

    public  JobPost toEntity(JobPostDto dto) {
        JobPost jobPost = new JobPost();
        jobPost.setPostId(dto.getPostId()); // Optional: skip setting if auto-generated
        jobPost.setPostProfile(dto.getPostProfile());
        jobPost.setPostDesc(dto.getPostDesc());
        jobPost.setReqExperience(dto.getReqExperience());
        jobPost.setPostTechStack(dto.getPostTechStack());
        return jobPost;
    }
}
