package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.transfer.JobDto;

import java.util.List;
import java.util.stream.Collectors;

public class JobMapper {


    public static JobDto toDto(Job job) {
        return JobDto.builder()
                .name(job.getName())
                .statsDto(StatsMapper.toDto(job.getStats()))
                .build();
    }

    public static Job toJob(JobDto jobDto) {
        return Job.builder()
                .name(jobDto.getName())
                .stats(StatsMapper.toStats(jobDto.getStatsDto()))
                .build();
    }

    public static List<JobDto> toDto(List<Job> jobList) {
        return jobList.stream()
                .map(JobMapper::toDto)
                .collect(Collectors.toList());
    }
}
