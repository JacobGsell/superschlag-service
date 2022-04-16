package com.jacob.superschlag.exception.mapping;

import com.jacob.superschlag.entity.Item;
import com.jacob.superschlag.exception.transfer.ItemDto;

public class ItemMapper {
    public static ItemDto toDto(Item item) {
        return ItemDto.builder()
                .name(item.getName())
                .itemType(item.getItemType())
                .statsDto(StatsMapper.toDto(item.getStats()))
                .build();
    }
}
