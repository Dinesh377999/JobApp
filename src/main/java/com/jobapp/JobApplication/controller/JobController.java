package com.jobapp.JobApplication.controller;


import com.jobapp.JobApplication.dto.JobPostDto;
import com.jobapp.JobApplication.service.JobPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobPost")
public class JobController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping("/getAll")
    public ResponseEntity<List<JobPostDto>> getAllJobs(){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.getAllJobs());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JobPostDto> getJob(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.getJob(id));
    }

    @PostMapping("/addJobs")
    public ResponseEntity<String> addJobs(@RequestBody @Valid List<JobPostDto> jobPostDtos){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPostService.addJobs(jobPostDtos));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody @Valid JobPostDto jobPostDto){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.add(jobPostDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id , @RequestBody JobPostDto jobPostDto ){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.update(id , jobPostDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.deleteJobPost(id));
    }

}
