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
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Stats stats;
}
