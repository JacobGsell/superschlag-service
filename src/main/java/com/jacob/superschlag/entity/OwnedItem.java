package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnedItem {
    @Id
    private long id;

    @OneToOne
    private Item item;

    private boolean isEquipped;
}
