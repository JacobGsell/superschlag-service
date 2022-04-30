package com.jacob.superschlag.repository;

import com.jacob.superschlag.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Job findByName(String name);
}
