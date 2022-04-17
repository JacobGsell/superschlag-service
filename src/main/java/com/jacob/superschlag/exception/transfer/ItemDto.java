package com.jacob.superschlag.exception.transfer;

import com.jacob.superschlag.entity.ItemType;
import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String name;
    private ItemType itemType;
    private StatsDto statsDto;
}
