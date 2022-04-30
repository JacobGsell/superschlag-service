package com.jacob.superschlag.access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarDao {
    private String name;

    private String jobId;

    private List<OwnedItemDao> ownedItemDaoList;
}
