package com.jacob.superschlag.service;

import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
        testInit();
    }

    public Job findJobById(long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return jobOptional.get();
    }

    public List<Job> findAllJobs() {
        List<Job> jobList = jobRepository.findAll();

        if (jobList.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return jobList;
    }

    private void testInit() {
        Job job1 = createJob("Ritter",
                20,
                50,
                2,
                30,
                130);

        Job job2 = createJob("Dieb",
                25,
                30,
                30,
                50,
                70);

        Job job3 = createJob("Milchmann",
                10,
                10,
                10,
                150,
                100);

        jobRepository.deleteAll();
        jobRepository.saveAll(List.of(job1, job2, job3));
    }

    private Job createJob(String name, int attack, int defense, int evasion, int luck, int health) {
        return Job.builder()
                .name(name)
                .stats(
                        Stats.builder()
                                .attack(attack)
                                .defense(defense)
                                .evasion(evasion)
                                .luck(luck)
                                .health(health)
                                .build()
                ).build();
    }
}