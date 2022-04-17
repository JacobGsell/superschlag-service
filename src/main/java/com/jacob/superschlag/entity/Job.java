package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    private long id;

    private String name;

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private Stats stats;
}
