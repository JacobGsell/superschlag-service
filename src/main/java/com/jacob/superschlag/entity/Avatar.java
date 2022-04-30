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
    private String id;

    private String name;

    private String jobId;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnedItem> ownedItemList;
}
