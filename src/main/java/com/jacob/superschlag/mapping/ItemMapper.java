package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.Item;
import com.jacob.superschlag.transfer.ItemDto;

public class ItemMapper {
    public static ItemDto toDto(Item item) {
        return ItemDto.builder()
                .name(item.getName())
                .itemType(item.getItemType())
                .statsDto(StatsMapper.toDto(item.getStats()))
                .build();
    }

    public static Item toItem(ItemDto itemDto) {
        return Item.builder()
                .name(itemDto.getName())
                .itemType(itemDto.getItemType())
                .stats(StatsMapper.toStats(itemDto.getStatsDto()))
                .build();
    }
}