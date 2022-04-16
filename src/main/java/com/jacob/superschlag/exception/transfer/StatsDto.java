package com.jacob.superschlag.exception.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class StatsDto {
    private int attack;
    private int defense;
    private int evasion;
    private int luck;
    private int health;
}
