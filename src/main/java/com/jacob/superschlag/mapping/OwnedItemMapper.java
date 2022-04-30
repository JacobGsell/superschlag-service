package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.transfer.OwnedItemDto;

import java.util.UUID;

public class OwnedItemMapper {
    public static OwnedItemDto toDto(OwnedItem ownedItem) {
        return OwnedItemDto.builder()
                .itemDto(ItemMapper.toDto(ownedItem.getItem()))
                .isEquipped(ownedItem.isEquipped())
                .build();
    }

    public static OwnedItem toOwnedItem(OwnedItemDto ownedItemDto) {
        return OwnedItem.builder()
                .id(UUID.randomUUID().toString())
                .item(ItemMapper.toItem(ownedItemDto.getItemDto()))
                .isEquipped(ownedItemDto.isEquipped())
                .build();
    }
}