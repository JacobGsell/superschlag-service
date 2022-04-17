package com.jacob.superschlag.exception.mapping;

import com.jacob.superschlag.entity.*;
import com.jacob.superschlag.exception.transfer.OwnedItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AvatarMapperTest {

    private AvatarMapper sut;

    @Test
    public void getAllStats_should_get_all_stats() {
        Stats stats1 = Stats.builder()
                .attack(1)
                .defense(1)
                .evasion(1)
                .luck(1)
                .health(1)
                .build();

        Stats stats2 = Stats.builder()
                .attack(2)
                .defense(2)
                .evasion(3)
                .luck(4)
                .health(7)
                .build();

        Stats stats3 = Stats.builder()
                .attack(2)
                .defense(2)
                .evasion(3)
                .luck(4)
                .health(9)
                .build();

        Job job = new Job();
        job.setStats(stats3);

        Avatar avatar = Avatar.builder()
                .ownedItemList(
                        List.of(
                                OwnedItem.builder()
                                        .item(
                                                Item.builder()
                                                        .stats(stats2)
                                                        .build())
                                        .isEquipped(true)
                                        .build(),
                                OwnedItem.builder()
                                        .item(
                                                Item.builder()
                                                        .stats(stats1)
                                                        .build())
                                        .isEquipped(false)
                                        .build()
                        )
                )
                .job(job)
                .build();


        int expectedStatsAmount = 2;
        List<Stats> actualStatsList = AvatarMapper.getAllStats(avatar);

        assertEquals(expectedStatsAmount, actualStatsList.size());
    }

    @Test
    public void getTotalStats_should_compute_stats_correctly() {
        Stats stats1 = Stats.builder()
                .attack(1)
                .defense(1)
                .evasion(1)
                .luck(1)
                .health(1)
                .build();

        Stats stats2 = Stats.builder()
                .attack(2)
                .defense(2)
                .evasion(3)
                .luck(4)
                .health(9)
                .build();

        Job job = new Job();
        job.setStats(stats2);

        Avatar avatar = Avatar.builder()
                .ownedItemList(
                        List.of(
                                OwnedItem.builder()
                                        .item(
                                                Item.builder()
                                                        .stats(stats1)
                                                        .build())
                                        .isEquipped(true)
                                        .build()
                        )
                )
                .job(job)
                .build();

        Stats actualStats = AvatarMapper.getTotalStats(avatar);
        Stats expectedStats = Stats.builder()
                .attack(3)
                .defense(3)
                .evasion(4)
                .luck(5)
                .health(10)
                .build();

        assertEquals(expectedStats, actualStats);
    }

    @Test
    public void getOwnedItemDtoList_should_map_OwnedItems_correctly() {
        Stats stats1 = Stats.builder()
                .attack(1)
                .defense(1)
                .evasion(1)
                .luck(1)
                .health(1)
                .build();

        Stats stats2 = Stats.builder()
                .attack(2)
                .defense(2)
                .evasion(3)
                .luck(4)
                .health(9)
                .build();

        OwnedItem ownedItem1 = OwnedItem.builder()
                .item(
                        Item.builder()
                                .name("item1")
                                .stats(stats1)
                                .build()
                )
                .build();

        OwnedItem ownedItem2 = OwnedItem.builder()
                .item(
                        Item.builder()
                                .name("item2")
                                .stats(stats2)
                                .build()
                )
                .build();


        Avatar avatar = Avatar.builder()
                .ownedItemList(List.of(ownedItem1, ownedItem2))
                .build();

        List<OwnedItemDto> ownedItemDtoList = AvatarMapper.getOwnedItemDtoList(avatar);

        assertEquals("item1", ownedItemDtoList.get(0).getItemDto().getName());
        assertEquals("item2", ownedItemDtoList.get(1).getItemDto().getName());
    }
}