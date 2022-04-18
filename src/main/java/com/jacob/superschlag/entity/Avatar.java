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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Job job;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnedItem> ownedItemList;
}
