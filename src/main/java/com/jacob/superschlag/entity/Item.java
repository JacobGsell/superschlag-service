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
public class Item {
    @Id
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @OneToOne
    private Stats stats;
}
