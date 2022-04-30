package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.transfer.StatsDto;

public class StatsMapper {
    public static StatsDto toDto(Stats stats) {
        return StatsDto.builder()
                .id(stats.getId())
                .attack(stats.getAttack())
                .defense(stats.getDefense())
                .evasion(stats.getEvasion())
                .luck(stats.getLuck())
                .health(stats.getHealth())
                .build();
    }

    public static Stats toStats(StatsDto statsDto) {
        return Stats.builder()
                .id(statsDto.getId())
                .attack(statsDto.getAttack())
                .defense(statsDto.getDefense())
                .evasion(statsDto.getEvasion())
                .luck(statsDto.getLuck())
                .health(statsDto.getHealth())
                .build();
    }
}
