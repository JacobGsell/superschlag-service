package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.Item;
import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.service.ItemService;
import com.jacob.superschlag.transfer.OwnedItemDto;
import org.springframework.beans.factory.annotation.Autowired;

public class OwnedItemMapper {

    private static ItemService itemService;

    @Autowired
    public OwnedItemMapper(ItemService itemService) {
        OwnedItemMapper.itemService = itemService;
    }

    public static OwnedItemDto toDto(OwnedItem ownedItem) {
        Item item = itemService.getItemById(ownedItem.getItemId());

        return OwnedItemDto.builder()
                .id(ownedItem.getId())
                .itemDto(ItemMapper.toDto(item))
                .isEquipped(ownedItem.isEquipped())
                .build();
    }

    public static OwnedItem toOwnedItem(OwnedItemDto ownedItemDto) {
        return OwnedItem.builder()
                .id(ownedItemDto.getId())
                .itemId(ownedItemDto.getItemDto().getId())
                .isEquipped(ownedItemDto.isEquipped())
                .build();
    }
}