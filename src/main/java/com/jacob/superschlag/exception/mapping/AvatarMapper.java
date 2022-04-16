package com.jacob.superschlag.exception.mapping;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.exception.transfer.AvatarDto;
import com.jacob.superschlag.exception.transfer.OwnedItemDto;

import java.util.List;
import java.util.stream.Collectors;

public class AvatarMapper {
    public static AvatarDto toDto(Avatar avatar) {
        return AvatarDto.builder()
                .name(avatar.getName())
                .jobDto(JobMapper.toDto(avatar.getJob()))
                .totalStats(getTotalStats(avatar))
                .
                .build();
    }

    static Stats getTotalStats(Avatar avatar) {
        Stats totalStats;

        List<Stats> allStats = getAllStats(avatar);

        totalStats = allStats.stream()
                .reduce(new Stats(), (base, element) -> {
                    base.setAttack(base.getAttack() + element.getAttack());
                    base.setDefense(base.getDefense() + element.getDefense());
                    base.setEvasion(base.getEvasion() + element.getEvasion());
                    base.setLuck(base.getLuck() + element.getLuck());
                    base.setHealth(base.getHealth() + element.getHealth());
                    return base;
                });

        return totalStats;
    }

    static List<Stats> getAllStats(Avatar avatar) {
        List<Stats> allStats;

        allStats = avatar.getOwnedItemList()
                .stream()
                .filter(OwnedItem::isEquipped)
                .map(ownedItem -> ownedItem.getItem().getStats())
                .collect(Collectors.toList());

        allStats.add(avatar.getJob().getStats());

        return allStats;
    }

    static List<OwnedItemDto> getItemDtos() {
        // Todo
    }
}
