package com.jacob.superschlag.service;

import com.jacob.superschlag.entity.Item;
import com.jacob.superschlag.entity.ItemType;
import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    private void init() {
        createInitialItemsForTesting();
    }

    public Item getItemById(String id) {
        Optional<Item> itemOptional = itemRepository.findById(id);

        if (itemOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return itemOptional.get();
    }

    private void createInitialItemsForTesting() {
        Item item1 = createItem(
                "1",
                "schwert",
                ItemType.WEAPON,
                10,
                0,
                2,
                2,
                0);

        Item item2 = createItem(
                "2",
                "Schild",
                ItemType.ARMOR,
                0,
                10,
                0,
                0,
                5);

        Item item3 = createItem(
                "3",
                "Heftklammer",
                ItemType.WEAPON,
                2,
                0,
                2,
                2,
                2);

        itemRepository.deleteAll();
        itemRepository.saveAll(List.of(item1, item2, item3));
    }

    private Item createItem(String id, String name, ItemType itemType, int attack, int defense, int evasion, int luck, int health) {
        return Item.builder()
                .id(id)
                .name(name)
                .itemType(itemType)
                .stats(
                        Stats.builder()
                                .id(UUID.randomUUID().toString())
                                .attack(attack)
                                .defense(defense)
                                .evasion(evasion)
                                .luck(luck)
                                .health(health)
                                .build()
                ).build();
    }
}
