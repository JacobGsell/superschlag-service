package com.jacob.superschlag.exception.mapping;

import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.exception.transfer.AvatarDto;
import com.jacob.superschlag.exception.transfer.JobDto;

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
}
