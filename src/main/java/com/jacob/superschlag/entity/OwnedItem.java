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
public class OwnedItem {
    @Id
    private long id;

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private Item item;

    private boolean isEquipped;
}
