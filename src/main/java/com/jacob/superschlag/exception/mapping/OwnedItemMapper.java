package com.jacob.superschlag.exception.mapping;

import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.exception.transfer.OwnedItemDto;

public class OwnedItemMapper {
    public static OwnedItemDto toDto(OwnedItem ownedItem) {
        return OwnedItemDto.builder()
                .itemDto(ItemMapper.toDto(ownedItem.getItem()))
                .isEquipped(ownedItem.isEquipped())
                .build();
    }
}