package com.jacob.superschlag.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnedItem {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private Item item;

    private boolean isEquipped;
}
