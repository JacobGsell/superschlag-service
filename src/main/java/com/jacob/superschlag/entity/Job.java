package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    private long id;

    private String name;

    @OneToOne
    private Stats stats;
}
