package com.jacob.superschlag.transfer;

import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatsDto {
    private String id;
    private int attack;
    private int defense;
    private int evasion;
    private int luck;
    private int health;
}
