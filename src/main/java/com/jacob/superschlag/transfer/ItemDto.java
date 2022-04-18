package com.jacob.superschlag.transfer;

import com.jacob.superschlag.entity.ItemType;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    @NotNull
    private String name;

    private ItemType itemType;

    private StatsDto statsDto;
}
