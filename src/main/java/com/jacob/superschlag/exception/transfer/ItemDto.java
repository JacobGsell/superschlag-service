package com.jacob.superschlag.exception.transfer;

import com.jacob.superschlag.entity.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class ItemDto {
    private String name;
    private ItemType itemType;
    private StatsDto statsDto;
}
