package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stats {
    @Id
    @GeneratedValue
    private long id;

    private int attack;
    private int defense;
    private int evasion;
    private int luck;
    private int health;
}
