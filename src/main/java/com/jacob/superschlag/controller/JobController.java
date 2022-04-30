package com.jacob.superschlag.controller;

import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.mapping.JobMapper;
import com.jacob.superschlag.service.JobService;
import com.jacob.superschlag.transfer.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/jobs")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public @ResponseBody
    List<JobDto> getAllJobs() {
        List<Job> jobList = this.jobService.findAllJobs();
        List<JobDto> jobDtoList = JobMapper.toDto(jobList);

        return jobDtoList;
    }

    @GetMapping(value = "/{jobId}")
    public @ResponseBody
    JobDto getJobById(@PathVariable String jobId) {
        Job job = this.jobService.findJobById(jobId);
        JobDto jobDto = JobMapper.toDto(job);

        return jobDto;
    }
}
