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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Item item;

    private boolean isEquipped;
}
