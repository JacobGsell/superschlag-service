package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Battle {
    @Id
    private long id;

    private int round;
    private int aggressorCurrentHealth;
    private int retaliatorCurrentHealth;

    @OneToOne
    private User aggressor;

    @OneToOne
    private User retaliator;

    private LocalDateTime lastStatusChangeDate;

    @Enumerated(EnumType.STRING)
    private BattleStatus battleStatus;
}
