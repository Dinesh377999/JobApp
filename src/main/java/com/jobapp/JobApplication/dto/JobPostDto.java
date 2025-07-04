package com.jobapp.JobApplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class JobPostDto {

    private int postId;
    @NotBlank(message = "Post profile is required")
    private String postProfile;

    @NotBlank(message = "Post description is required")
    private String postDesc;

    @Min(value = 0, message = "Experience must be non-negative")
    private int reqExperience;

    @NotNull(message = "Tech stack is required")
    private List<String> postTechStack;

    public JobPostDto() {}

    public JobPostDto(int postId, String postProfile, String postDesc, int reqExperience, List<String> postTechStack) {
        this.postId = postId;
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExperience = reqExperience;
        this.postTechStack = postTechStack;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public int getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience) {
        this.reqExperience = reqExperience;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }
}
