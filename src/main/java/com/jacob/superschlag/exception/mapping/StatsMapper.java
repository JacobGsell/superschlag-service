package com.jacob.superschlag.exception.mapping;

import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.exception.transfer.StatsDto;

public class StatsMapper {
    public static StatsDto toDto(Stats stats) {
        return StatsDto.builder()
                .attack(stats.getAttack())
                .defense(stats.getDefense())
                .evasion(stats.getEvasion())
                .luck(stats.getLuck())
                .health(stats.getHealth())
                .build();
    }
}
