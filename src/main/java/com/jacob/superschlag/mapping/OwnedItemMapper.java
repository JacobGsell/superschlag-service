package com.jacob.superschlag.mapping;

import com.jacob.superschlag.access.OwnedItemDao;
import com.jacob.superschlag.entity.Item;
import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.service.ItemService;
import com.jacob.superschlag.transfer.OwnedItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OwnedItemMapper {

    private static ItemService staticItemService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private void setItemService(ItemService itemService) {
        OwnedItemMapper.staticItemService = itemService;
    }

    public static OwnedItemDto toDto(OwnedItem ownedItem) {
        Item item = staticItemService.getItemById(ownedItem.getItemId());

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

    public static OwnedItem toOwnedItem(OwnedItemDao ownedItemDao) {
        return OwnedItem.builder()
                .id(UUID.randomUUID().toString())
                .itemId(ownedItemDao.getItemId())
                .isEquipped(ownedItemDao.isEquipped())
                .build();
    }
}