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
    private String id;

    private String itemId;

    private boolean isEquipped;
}
