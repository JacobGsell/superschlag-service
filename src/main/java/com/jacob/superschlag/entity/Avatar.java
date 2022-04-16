package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {
    @Id
    private long id;

    private String name;

    @ManyToOne
    private Job job;

    @OneToMany
    private List<OwnedItem> ownedItemList;
}
